package fiap._2tdspr.kciao.usecases.services.auth;

import fiap._2tdspr.kciao.domains.Cliente;
import fiap._2tdspr.kciao.gateways.repositories.ClienteRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    private final ClienteRepository clienteRepository;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private SecretKey key;

    public JwtUtil(ClienteRepository clienteRepository) {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        this.clienteRepository = clienteRepository;
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        var authorities = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        Cliente cliente = clienteRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        claims.put("id_cliente", cliente.getId_cliente());
        claims.put("nome", cliente.getNm_cliente());
        claims.put("email", cliente.getEmail());
        claims.put("form", cliente.getForm());
        claims.put("roles", authorities);
        claims.put("sub", userDetails.getUsername());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            logger.error("Token expirado: {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            logger.error("Token não suportado: {}", ex.getMessage());
        } catch (MalformedJwtException ex) {
            logger.error("Token malformado: {}", ex.getMessage());
        } catch (SignatureException ex) {
            logger.error("Assinatura inválida: {}", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            logger.error("Claim vazio: {}", ex.getMessage());
        }
        return false;
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Collection getRolesFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("roles", Collection.class);
    }

    public Boolean getFormFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("form", Boolean.class);
    }

    public Map<String, Object> getBasicUserInfo(String header) {

        String token = extractToken(header);
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("id_cliente", claims.get("id_cliente"));
        userInfo.put("nome", claims.get("nome"));
        userInfo.put("email", claims.get("email"));

        return userInfo;
    }

    public String extractToken(String header) {
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        throw new IllegalArgumentException("Token JWT ausente ou malformado");
    }


}