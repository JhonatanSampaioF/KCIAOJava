package fiap._2tdspr.kciao.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doenca {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_doenca;
    @Column(unique = true)
    private String nm_doenca;
    @ManyToMany
    @JoinTable(
            name = "cliente_doenca",
            joinColumns = @JoinColumn(name = "doenca_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> fk_cliente;
}
