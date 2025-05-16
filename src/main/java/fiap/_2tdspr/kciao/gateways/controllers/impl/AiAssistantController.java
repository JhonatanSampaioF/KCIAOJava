package fiap._2tdspr.kciao.gateways.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/informacoes")
@RequiredArgsConstructor
public class AiAssistantController {

    private final OllamaChatModel ollamaChatModel;

    @GetMapping("/clientes")
    public String openAiChat(@RequestParam(value = "message",
            defaultValue = "Quantos clientes são cadastrados?") String message) {
        return ollamaChatModel.call(message);
    }
}
