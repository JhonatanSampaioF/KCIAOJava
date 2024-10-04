package fiap._2tdspr.kciao.gateways.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DoencaRequestPatchDto {
    @NotEmpty
    private String nm_doenca;
}
