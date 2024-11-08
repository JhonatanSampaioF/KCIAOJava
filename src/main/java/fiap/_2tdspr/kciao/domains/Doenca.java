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
@Table(name = "tb_repositorio_doenca")
public class Doenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doenca")
    private Long id_doenca;
    @Column(name = "nm_doenca",unique = true)
    private String nm_doenca;
    @ManyToMany(mappedBy = "fk_doencas")
    private List<Cliente> fk_cliente;
}
