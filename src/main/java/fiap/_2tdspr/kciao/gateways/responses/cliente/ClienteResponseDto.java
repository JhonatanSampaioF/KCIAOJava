package fiap._2tdspr.kciao.gateways.responses.cliente;

import com.fasterxml.jackson.annotation.JsonInclude;
import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClienteResponseDto extends RepresentationModel<ClienteResponseDto> {
    private String id_cliente;
    private String nm_cliente;
    private String email;
    private List<String> doencas;
    private List<String> nm_doencas;
}
