package fiap._2tdspr.kciao.gateways;

import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPatchNameDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPostDto;
import fiap._2tdspr.kciao.gateways.requests.DoencaRequestPutDto;
import fiap._2tdspr.kciao.gateways.responses.DoencaResponseDto;
import org.springframework.http.ResponseEntity;

public class DoencaControllerImpl implements DoencaController{
    @Override
    public ResponseEntity<DoencaResponseDto> getDoenca(String id) {
        return null;
    }

    @Override
    public ResponseEntity<DoencaResponseDto> getAllDoenca() {
        return null;
    }

    @Override
    public ResponseEntity<DoencaResponseDto> criarDoenca(DoencaRequestPostDto doenca) {
        return null;
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
