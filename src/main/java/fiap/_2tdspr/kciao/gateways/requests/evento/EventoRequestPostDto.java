package fiap._2tdspr.kciao.gateways.requests.evento;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.sql.Date;

@Data
public class EventoRequestPostDto {
    @NotEmpty
    private String tipo_evento;
    @NotEmpty
    private String desc_evento;
    @NotEmpty
    private Date dt_evento;
    @NotEmpty
    private String fk_cliente;
}
