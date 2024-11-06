package fiap._2tdspr.kciao.gateways.requests.consulta;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ConsultaRequestPatchLocalDto {
    @NotEmpty
    private String profissional;
    @NotEmpty
    private String local_consulta;
}
