package fiap._2tdspr.kciao.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_cliente;
    private String nm_cliente;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(mappedBy = "fk_cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evento> eventos;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "cliente_doenca",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "doenca_id")
    )
    private List<Doenca> fk_doencas;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.email;  // Ou o campo que você usa como username
    }
}
