package fiap._2tdspr.kciao.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_cliente;
    private String nm_cliente;
    private String email;
    private String password;

    @OneToMany(mappedBy = "fk_cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evento> eventos;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "cliente_doenca",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "doenca_id")
    )
    private List<Doenca> fk_doencas;
}
