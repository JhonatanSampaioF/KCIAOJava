package fiap._2tdspr.kciao.usecases.services.auth;

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

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private SecretKey key;

    // Constructor to initialize the key
    public JwtUtil() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS512);  // Use secure key generation for HS512
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("roles", userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

        claims.put("sub", userDetails.getUsername());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)  // Use the generated key
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);  // Use the generated key
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
}