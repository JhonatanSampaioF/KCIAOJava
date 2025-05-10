package fiap._2tdspr.kciao.configs;

import org.springframework.amqp.support.converter.DefaultClassMapper;

public class CustomClassMapper extends DefaultClassMapper {
    public CustomClassMapper() {
        super();
        // Allow deserialization of ClienteResponseDto class
        this.setTrustedPackages("fiap._2tdspr.kciao.gateways.responses.cliente");
    }
}
