package fiap._2tdspr.kciao.gateways.requests.doenca;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DoencaRequestDto {
    @NotEmpty
    private String nm_doenca;
}
