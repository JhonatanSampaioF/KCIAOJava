package fiap._2tdspr.kciao.usecases.doencas.interfaces;

import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.responses.DoencaResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudDoenca {
    DoencaResponseDto save(DoencaRequestDto doencaRequestDto);
    Optional<DoencaResponseDto> getOne(String id);
    List<DoencaResponseDto> getAll();
    Optional<DoencaResponseDto> update(String id, DoencaRequestDto doencaRequestDto);
    void delete(String id);

}
