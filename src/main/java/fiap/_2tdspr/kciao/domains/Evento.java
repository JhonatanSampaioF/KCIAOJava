package fiap._2tdspr.kciao.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_evento;
    private String tipo_evento;
    private String desc_evento;
    private Date dt_evento;
    @ManyToOne
    @JoinColumn(name = "fk_cliente_id", nullable = false)
    private Cliente cliente;
}
