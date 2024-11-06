package fiap._2tdspr.kciao.gateways.requests.evento;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.sql.Date;

@Data
public class EventoRequestPatchDataDto {
    @NotEmpty
    private Date dt_evento;
}
