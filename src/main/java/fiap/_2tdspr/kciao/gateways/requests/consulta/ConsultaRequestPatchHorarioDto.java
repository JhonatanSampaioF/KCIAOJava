package fiap._2tdspr.kciao.gateways.requests.consulta;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ConsultaRequestPatchHorarioDto {
    @NotEmpty
    private Integer horario_consulta;
}
