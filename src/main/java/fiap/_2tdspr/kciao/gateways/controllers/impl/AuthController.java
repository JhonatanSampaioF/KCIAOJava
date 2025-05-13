package fiap._2tdspr.kciao.gateways.controllers.impl;

import fiap._2tdspr.kciao.gateways.requests.LoginRequest;
import fiap._2tdspr.kciao.usecases.interfaces.CrudRoles;
import fiap._2tdspr.kciao.usecases.services.auth.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final CrudRoles crudRoles;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/role")
    public ResponseEntity<String> createRole(@RequestParam String role) {
        return ResponseEntity.ok(crudRoles.save(role));
    }
}
