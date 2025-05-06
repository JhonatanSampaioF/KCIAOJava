package fiap._2tdspr.kciao.gateways.requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
