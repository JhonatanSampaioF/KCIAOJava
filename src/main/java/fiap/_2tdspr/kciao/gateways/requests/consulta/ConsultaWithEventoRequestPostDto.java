package fiap._2tdspr.kciao.gateways.requests.consulta;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
public class ConsultaWithEventoRequestPostDto {
    @NotEmpty
    private String profissional;
    @NotEmpty
    private String local_consulta;
    @NotNull
    private Integer horario_consulta;
    @NotEmpty
    private String tipo_evento;
    @NotEmpty
    private String desc_evento;
    @NotNull
    private Date dt_evento;
    @NotNull
    private String fk_cliente;
}
