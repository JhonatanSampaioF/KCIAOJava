package fiap._2tdspr.kciao.gateways.responses.cliente;

import com.fasterxml.jackson.annotation.JsonInclude;
import fiap._2tdspr.kciao.domains.Doenca;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClienteResponseDto extends RepresentationModel<ClienteResponseDto> {
    private String id_cliente;
    private String nm_cliente;
    private List<Doenca> doencas;
    private List<String> nm_doencas;
}
