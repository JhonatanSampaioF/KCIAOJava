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
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id_cliente;
    @Column(name = "nm_cliente")
    private String nm_cliente;
    @ManyToMany
    @JoinTable(
            name = "tb_cliente_doenca",
            joinColumns = @JoinColumn(name = "fk_cliente"),
            inverseJoinColumns = @JoinColumn(name = "fk_doenca")
    )
    private List<Doenca> fk_doencas;
}
