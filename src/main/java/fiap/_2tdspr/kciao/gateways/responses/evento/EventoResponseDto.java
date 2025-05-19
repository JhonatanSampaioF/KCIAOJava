package fiap._2tdspr.kciao.gateways.responses.evento;

import com.fasterxml.jackson.annotation.JsonInclude;
import fiap._2tdspr.kciao.domains.Cliente;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EventoResponseDto extends RepresentationModel<EventoResponseDto> {
    private String id_evento;
    private String tipo_evento;
    private String desc_evento;
    private Date dt_evento;
    private Cliente fk_cliente;
}
