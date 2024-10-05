package fiap._2tdspr.kciao.usecases.doencas.interfaces;

import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPostDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPatchDto;
import fiap._2tdspr.kciao.gateways.responses.DoencaResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CrudDoenca {
    DoencaResponseDto save(DoencaRequestPostDto doencaRequestPostDto);
    Optional<DoencaResponseDto> getOne(String id);
    List<DoencaResponseDto> getAll();
    Optional<DoencaResponseDto> update(String id, DoencaRequestPatchDto doencaRequestPatchDto);
    void delete(String id);

}
