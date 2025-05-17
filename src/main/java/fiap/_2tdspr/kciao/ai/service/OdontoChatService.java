package fiap._2tdspr.kciao.ai.service;

import fiap._2tdspr.kciao.ai.tools.ListarDoencasTool;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OdontoChatService {

    private final ChatModel chatModel;
    private final ListarDoencasTool listarDoencasTool;

    public String getRecomendacoes(String clienteId) {
        ChatClient chatClient = ChatClient.create(chatModel); // Crie o ChatClient

        return chatClient.prompt()
                .system("Você é um assistente odontológico especialista em cuidados bucais. "
                        + "Analise as doenças do cliente e forneça recomendações personalizadas. " +
                        "Se não encontrar, não invente doenças, apenas assuma que o cliente não possui")
                .user("Cliente ID: " + clienteId + ". Forneça recomendações baseadas nas doenças.")
                .tools(listarDoencasTool)
                .call()
                .content();
    }
}