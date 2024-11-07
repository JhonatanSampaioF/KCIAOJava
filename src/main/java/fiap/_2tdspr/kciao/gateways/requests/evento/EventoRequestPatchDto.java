package fiap._2tdspr.kciao.gateways.requests.evento;

import lombok.Data;

import java.sql.Date;

@Data
public class EventoRequestPatchDto {
    private String tipo_evento;
    private String desc_evento;
    private Date dt_evento;
}
