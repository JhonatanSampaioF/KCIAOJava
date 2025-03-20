package fiap._2tdspr.kciao.gateways.requests.consulta;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
public class ConsultaWithEventoRequestPatchDto {
    private String profissional;
    private String local_consulta;
    private Integer horario_consulta;
    private String tipo_evento;
    private String desc_evento;
    private Date dt_evento;
}
