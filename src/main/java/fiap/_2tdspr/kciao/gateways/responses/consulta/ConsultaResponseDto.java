package fiap._2tdspr.kciao.gateways.responses.consulta;

import fiap._2tdspr.kciao.gateways.responses.evento.EventoResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsultaResponseDto {
    private String profissional;
    private String local_consulta;
    private Integer horario_consulta;
    private EventoResponseDto fk_evento;
}
