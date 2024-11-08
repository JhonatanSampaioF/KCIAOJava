package fiap._2tdspr.kciao.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Long id_consulta;
    @Column(name = "profissional")
    private String profissional;
    @Column(name = "local_consulta")
    private String local_consulta;
    @Column(name = "horario_consulta")
    private Integer horario_consulta;
    @OneToOne
    @JoinColumn(name = "fk_evento", referencedColumnName = "id_evento", unique = true)
    private Evento fk_evento;
}
