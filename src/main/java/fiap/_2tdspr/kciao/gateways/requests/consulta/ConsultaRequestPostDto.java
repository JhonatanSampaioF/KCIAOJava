package fiap._2tdspr.kciao.gateways.requests.consulta;

import fiap._2tdspr.kciao.domains.Evento;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConsultaRequestPostDto {
    @NotEmpty
    private String profissional;
    @NotEmpty
    private String local_consulta;
    @NotNull
    private Integer horario_consulta;
    @NotNull
    private Evento fk_evento;
}
