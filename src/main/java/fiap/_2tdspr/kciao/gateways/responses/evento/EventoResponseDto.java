package fiap._2tdspr.kciao.gateways.responses.evento;

import com.fasterxml.jackson.annotation.JsonInclude;
import fiap._2tdspr.kciao.domains.Cliente;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EventoResponseDto extends RepresentationModel<EventoResponseDto> {
    private String tipo_evento;
    private String desc_evento;
    private Date dt_evento;
    private Cliente fk_cliente;
}
