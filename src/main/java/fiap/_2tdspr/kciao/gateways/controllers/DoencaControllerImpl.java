package fiap._2tdspr.kciao.gateways.controllers;

import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.DoencaResponseDto;
import fiap._2tdspr.kciao.usecases.doencas.impl.CrudDoencaImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DoencaControllerImpl implements DoencaController{

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
    public ResponseEntity<DoencaResponseDto> criarDoenca(DoencaRequestPostDto doencaRequestDto) {

        DoencaResponseDto doencaSalva = crudDoenca.save(doencaRequestDto);

        return ResponseEntity.of(Optional.of(doencaSalva));
    }

    @Override
    public ResponseEntity<Optional<Optional<DoencaResponseDto>>> atualizarDoencaCompleta(String id, DoencaRequestPatchDto doencaRequestPutDto) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<DoencaResponseDto>> atualizarDoencaParcial(String id, DoencaRequestPatchDto doencaRequestPatchDto) {

        Optional<DoencaResponseDto> doencaResponseDto = crudDoenca.update(id,doencaRequestPatchDto);

        return ResponseEntity.of(Optional.of(doencaResponseDto));
    }

    @Override
    public void deletarDoenca(String id) {
        crudDoenca.delete(id);
    }
}
