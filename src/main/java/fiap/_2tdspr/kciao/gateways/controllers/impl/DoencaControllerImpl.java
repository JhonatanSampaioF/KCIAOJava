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
    public void criarDoenca(DoencaRequestDto doenca) {
        crudDoenca.save(doenca);
    }

    @Override
    public void atualizarDoenca(Long id, DoencaRequestDto doencaRequestDto) {
        crudDoenca.update(id, doencaRequestDto);
    }

    @Override
    public void deletarDoenca(Long id) {
        crudDoenca.delete(id);
    }
}
