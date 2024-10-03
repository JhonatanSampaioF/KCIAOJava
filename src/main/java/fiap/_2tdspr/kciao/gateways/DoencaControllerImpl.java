package fiap._2tdspr.kciao.gateways;

import fiap._2tdspr.kciao.domains.Doenca;
import fiap._2tdspr.kciao.gateways.repositories.DoencaRepository;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPatchNameDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPostDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPutDto;
import fiap._2tdspr.kciao.gateways.responses.DoencaResponseDto;
import fiap._2tdspr.kciao.usecases.impl.SalvarDoenca;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DoencaControllerImpl implements DoencaController{


    private final SalvarDoenca salvarDoenca;
    private final DoencaRepository doencaRepository;
    @Override
    public ResponseEntity<List<Doenca>> getDoenca(String id) {
        Optional<Doenca> getUmaDoenca = doencaRepository.findById(id);
        DoencaResponseDto doenca = DoencaResponseDto.builder()
                .nm_doenca(getUmaDoenca.getNm_doenca())
                .build();
        return ResponseEntity.ok(doenca);
    }

    @Override
    public ResponseEntity<List<DoencaResponseDto>> getAllDoenca() {
        List<Doenca> getAllDoenca = doencaRepository.findAll();
        List<DoencaResponseDto> getAllDoencaResponse = getAllDoenca.map(d -> DoencaResponseDto.builder()
                        .nm_doenca(d.getNm_doenca())
                        .build())
                .orElseThrow(() -> new RuntimeException("Doenca not found"));



        return ResponseEntity.ok(getAllDoenca);
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
