package fiap._2tdspr.kciao.gateways.requests.consulta;

import lombok.Data;

@Data
public class ConsultaRequestPatchDto {
    private String profissional;
    private String local_consulta;
    private Integer horario_consulta;
}
