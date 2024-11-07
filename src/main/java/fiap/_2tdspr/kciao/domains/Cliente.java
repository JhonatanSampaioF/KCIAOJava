package fiap._2tdspr.kciao.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

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
    @ManyToMany
    private List<Doenca> fk_doencas;
}
