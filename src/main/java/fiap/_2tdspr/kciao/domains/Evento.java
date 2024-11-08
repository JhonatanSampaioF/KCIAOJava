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
@Table(name = "tb_evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Long id_evento;
    @Column(name = "tipo_evento")
    private String tipo_evento;
    @Column(name = "desc_evento")
    private String desc_evento;
    @Column(name = "dt_evento")
    private Date dt_evento;
    @ManyToOne
    private Cliente fk_cliente;
}
