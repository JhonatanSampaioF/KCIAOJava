package fiap._2tdspr.kciao.usecases.interfaces;

import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CrudDoenca {
    DoencaResponseDto save(DoencaRequestDto doencaRequestDto);
    DoencaResponseDto getOne(String id);
    List<DoencaResponseDto> getAll();
    DoencaResponseDto update(String id, DoencaRequestDto doencaRequestDto);
    void delete(String id);

}
