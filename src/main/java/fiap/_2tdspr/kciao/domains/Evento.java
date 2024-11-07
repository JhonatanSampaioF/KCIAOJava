package fiap._2tdspr.kciao.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_evento;
    private String tipo_evento;
    private String desc_evento;
    private Date dt_evento;
    @ManyToOne
    private Cliente fk_cliente;
}
