package fiap._2tdspr.kciao.gateways.requests.consulta;

import fiap._2tdspr.kciao.domains.Evento;
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
    private Evento fk_evento;
}
