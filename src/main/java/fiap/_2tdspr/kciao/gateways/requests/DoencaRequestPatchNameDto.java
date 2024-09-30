package fiap._2tdspr.kciao.gateways.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DoencaRequestPatchNameDto {
    @NotEmpty
    private String nm_doenca;
}
