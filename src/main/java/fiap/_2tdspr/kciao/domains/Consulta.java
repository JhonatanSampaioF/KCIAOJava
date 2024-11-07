package fiap._2tdspr.kciao.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_consulta;
    private String profissional;
    private String local_consulta;
    private Integer horario_consulta;
    @OneToOne
    private Evento fk_evento;
}
