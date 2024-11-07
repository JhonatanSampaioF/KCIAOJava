package fiap._2tdspr.kciao.gateways.controllers.impl;

import fiap._2tdspr.kciao.gateways.controllers.interfaces.ConsultaController;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPatchDto;
import fiap._2tdspr.kciao.gateways.requests.consulta.ConsultaRequestPostDto;
import fiap._2tdspr.kciao.gateways.responses.consulta.ConsultaResponseDto;
import fiap._2tdspr.kciao.usecases.impl.CrudConsultaImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ConsultaControllerImpl implements ConsultaController {

    private final CrudConsultaImpl crudConsulta;

    @Override
    public ResponseEntity<Optional<ConsultaResponseDto>> getConsulta(String id) {

        Optional<ConsultaResponseDto> consultaResponseDto = crudConsulta.getOne(id);

        return ResponseEntity.of(Optional.of(consultaResponseDto));
    }

    @Override
    public ResponseEntity<List<ConsultaResponseDto>> getAllConsulta() {

        List<ConsultaResponseDto> consultaResponseDtoList = crudConsulta.getAll();

        return ResponseEntity.ok(consultaResponseDtoList);
    }

    @Override
    public ResponseEntity<ConsultaResponseDto> criarConsulta(ConsultaRequestPostDto consulta) {

        ConsultaResponseDto consultaSalva = crudConsulta.save(consulta);

        return ResponseEntity.of(Optional.of(consultaSalva));
    }

    @Override
    public ResponseEntity<Optional<ConsultaResponseDto>> atualizarConsulta(String id, ConsultaRequestPatchDto consultaRequestPatchDto) {

        Optional<ConsultaResponseDto> consultaResponseDto = crudConsulta.update(id, consultaRequestPatchDto);

        return ResponseEntity.of(Optional.of(consultaResponseDto));
    }

    @Override
    public void deletarConsulta(String id) {
        crudConsulta.delete(id);
    }
}
