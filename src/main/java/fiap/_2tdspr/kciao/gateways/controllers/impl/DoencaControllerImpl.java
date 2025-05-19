package fiap._2tdspr.kciao.gateways.controllers.impl;

import fiap._2tdspr.kciao.gateways.controllers.interfaces.DoencaController;
import fiap._2tdspr.kciao.gateways.requests.doenca.DoencaRequestDto;
import fiap._2tdspr.kciao.gateways.responses.doenca.DoencaResponseDto;
import fiap._2tdspr.kciao.usecases.impl.CrudDoencaImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doenca")
public class DoencaControllerImpl implements DoencaController {

    private final CrudDoencaImpl crudDoenca;

    @Override
    public ResponseEntity<DoencaResponseDto> getDoenca(String id) {

        DoencaResponseDto doencaResponseDto = crudDoenca.getOne(id);

        return ResponseEntity.ok(doencaResponseDto);
    }

    @Override
    public ResponseEntity<List<DoencaResponseDto>> getAllDoenca() {

        List<DoencaResponseDto> doencaResponseDtoList = crudDoenca.getAll();

        return ResponseEntity.ok(doencaResponseDtoList);
    }

    @Override
    public ResponseEntity<DoencaResponseDto> criarDoenca(DoencaRequestDto doenca) {

        DoencaResponseDto doencaSalva = crudDoenca.save(doenca);

        return ResponseEntity.ok(doencaSalva);
    }

    @Override
    public ResponseEntity<DoencaResponseDto> atualizarDoenca(String id, DoencaRequestDto doencaRequestDto) {

        DoencaResponseDto doencaResponseDto = crudDoenca.update(id, doencaRequestDto);

        return ResponseEntity.ok(doencaResponseDto);
    }

    @Override
    public void deletarDoenca(String id) {
        crudDoenca.delete(id);
    }
}
