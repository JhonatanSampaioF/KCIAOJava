package fiap._2tdspr.kciao.gateways.requests.evento;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EventoRequestPatchTipoDto {
    @NotEmpty
    private String tipo_evento;
    @NotEmpty
    private String desc_evento;
}
