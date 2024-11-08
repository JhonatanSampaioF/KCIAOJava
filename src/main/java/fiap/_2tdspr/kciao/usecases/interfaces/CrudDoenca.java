package fiap._2tdspr.kciao.usecases.interfaces;

import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudDoenca {
    void save(DoencaRequestDto doencaRequestDto);
    void update(Long id, DoencaRequestDto doencaRequestDto);
    void delete(Long id);

}
