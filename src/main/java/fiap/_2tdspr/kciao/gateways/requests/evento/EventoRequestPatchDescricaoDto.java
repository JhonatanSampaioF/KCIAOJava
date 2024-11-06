package fiap._2tdspr.kciao.gateways.requests.evento;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EventoRequestPatchDescricaoDto {
    @NotEmpty
    private String desc_evento;
}
