package fiap._2tdspr.kciao.ai.controller;

import fiap._2tdspr.kciao.ai.service.OdontoChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/informacoes")
@RequiredArgsConstructor
public class OdontoController {

    private final OdontoChatService odontoChatService;

    @GetMapping("/{idCliente}")
    public ResponseEntity<String> getInformacoesCliente(@PathVariable String idCliente) {
        return ResponseEntity.ok(odontoChatService.getRecomendacoes(idCliente));
    }
}
