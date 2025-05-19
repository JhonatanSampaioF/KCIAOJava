package fiap._2tdspr.kciao.domains;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "consulta")
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
