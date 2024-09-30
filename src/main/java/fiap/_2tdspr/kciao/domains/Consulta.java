package fiap._2tdspr.kciao.domains;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
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
