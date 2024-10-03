package fiap._2tdspr.kciao.gateways;

import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.gateways.repositories.DoencaRepository;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPatchNameDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPostDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPutDto;
import fiap._2tdspr.kciao.gateways.responses.DoencaResponseDto;
import fiap._2tdspr.kciao.usecases.impl.SalvarDoenca;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DoencaControllerImpl implements DoencaController{


    private final SalvarDoenca salvarDoenca;
    private final DoencaRepository doencaRepository;
    @Override
    public ResponseEntity<DoencaResponseDto> getDoenca(String id) {
        Optional<Doenca> getUmaDoenca = doencaRepository.findById(id);
        DoencaResponseDto doenca = DoencaResponseDto.builder()
                .nm_doenca(getUmaDoenca.getNm_doenca())
                .build();
        return ResponseEntity.ok(doenca);
//        return null;
    }

    @Override
    public ResponseEntity<DoencaResponseDto> getAllDoenca() {
        return null;
    }

    @Override
    public ResponseEntity<DoencaResponseDto> criarDoenca(DoencaRequestPostDto doenca) {

        Doenca doencaASerCriada = Doenca.builder()
            .nm_doenca(doenca.getNm_doenca())
            .build();

        Doenca doencaSalva = salvarDoenca.execute(doencaASerCriada);

        DoencaResponseDto doencaCriada = DoencaResponseDto.builder()
            .nm_doenca(doencaSalva.getNm_doenca())
            .build();

        return ResponseEntity.of(Optional.of(doencaCriada));
    }

    @Override
    public ResponseEntity<DoencaResponseDto> atualizarDoencaCompleta(String id, DoencaRequestPutDto doenca) {
        return null;
    }

    @Override
    public ResponseEntity<DoencaResponseDto> atualizarDoencaParcial(String id, DoencaRequestPatchNameDto doenca) {
        return null;
    }

    @Override
    public ResponseEntity<DoencaResponseDto> deletarDoenca(String id) {
        return null;
    }
}
