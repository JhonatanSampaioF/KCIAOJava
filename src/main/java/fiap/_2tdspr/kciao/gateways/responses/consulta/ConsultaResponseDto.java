package fiap._2tdspr.kciao.gateways.responses.consulta;

import com.fasterxml.jackson.annotation.JsonInclude;
import fiap._2tdspr.kciao.domains.Evento;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ConsultaResponseDto extends RepresentationModel<ConsultaResponseDto> {
    private String id_consulta;
    private String profissional;
    private String local_consulta;
    private Integer horario_consulta;
    private Evento fk_evento;
}
