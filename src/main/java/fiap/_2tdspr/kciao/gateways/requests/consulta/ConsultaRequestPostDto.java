package fiap._2tdspr.kciao.gateways.requests.consulta;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ConsultaRequestPostDto {
    @NotEmpty
    private String profissional;
    @NotEmpty
    private String local_consulta;
    @NotEmpty
    private Integer horario_consulta;
    @NotEmpty
    private String fk_evento;
}
