package fiap._2tdspr.kciao.gateways.responses.doenca;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DoencaResponseDto extends RepresentationModel<DoencaResponseDto> {
    private String id_doenca;
    private String nm_doenca;
}
