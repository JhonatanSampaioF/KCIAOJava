package fiap._2tdspr.kciao.gateways.requests.cliente;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class ClienteRequestDto {
    @NotEmpty
    private String nm_cliente;
    private String email;
    private String password;
    private String role;
    private List<String> doencas;
}
