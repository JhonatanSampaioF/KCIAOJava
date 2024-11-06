package fiap._2tdspr.kciao.gateways.controllers.impl;

import fiap._2tdspr.kciao.gateways.controllers.interfaces.DoencaController;
import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import fiap._2tdspr.kciao.usecases.impl.CrudDoencaImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DoencaControllerImpl implements DoencaController {

    private final CrudDoencaImpl crudDoenca;
    @Override
    public ResponseEntity<Optional<DoencaResponseDto>> getDoenca(String id) {

        Optional<DoencaResponseDto> doencaResponseDto = crudDoenca.getOne(id);

        return ResponseEntity.of(Optional.of(doencaResponseDto));
    }

    @Override
    public ResponseEntity<List<DoencaResponseDto>> getAllDoenca() {

        List<DoencaResponseDto> doencaResponseDtoList = crudDoenca.getAll();

        return ResponseEntity.ok(doencaResponseDtoList);
    }

    @Override
    public ResponseEntity<DoencaResponseDto> criarDoenca(DoencaRequestDto doencaRequestDto) {

        DoencaResponseDto doencaSalva = crudDoenca.save(doencaRequestDto);

        return ResponseEntity.of(Optional.of(doencaSalva));
    }

    @Override
    public ResponseEntity<Optional<DoencaResponseDto>> atualizarDoenca(String id, DoencaRequestDto doencaRequestDto) {

        Optional<DoencaResponseDto> doencaResponseDto = crudDoenca.update(id, doencaRequestDto);

        return ResponseEntity.of(Optional.of(doencaResponseDto));
    }

    @Override
    public void deletarDoenca(String id) {
        crudDoenca.delete(id);
    }
}
