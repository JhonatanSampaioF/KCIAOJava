package fiap._2tdspr.kciao.gateways.responses.evento;

import fiap._2tdspr.kciao.domains.Cliente;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class EventoResponseDto {
    private String tipo_evento;
    private String desc_evento;
    private Date dt_evento;
    private Cliente fk_cliente;
}
