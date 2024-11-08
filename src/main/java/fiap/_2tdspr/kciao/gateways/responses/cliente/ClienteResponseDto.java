package fiap._2tdspr.kciao.gateways.responses.cliente;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClienteResponseDto extends RepresentationModel<ClienteResponseDto> {
    private String id_cliente;
    private String nm_cliente;
}
