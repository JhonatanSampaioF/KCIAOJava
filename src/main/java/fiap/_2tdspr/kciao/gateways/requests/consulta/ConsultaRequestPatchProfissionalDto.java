package fiap._2tdspr.kciao.gateways.requests.consulta;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ConsultaRequestPatchProfissionalDto {
    @NotEmpty
    private String profissional;
}
