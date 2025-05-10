package fiap._2tdspr.kciao.usecases.services.messaging;

import fiap._2tdspr.kciao.gateways.responses.cliente.ClienteResponseDto;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;  // Injetando RabbitTemplate
    private final Queue clienteQueue;  // Injetando a fila clienteQueue

    // Envia a mensagem para a fila 'clienteQueue'
    public void sendClienteMessage(ClienteResponseDto clienteMessage) {
        rabbitTemplate.convertAndSend(
                "clienteExchange", // Nome do exchange
                "", // Routing key vazia para Fanout
                clienteMessage,
                message -> {
                    message.getMessageProperties().setContentType("application/json");
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    return message;
                }
        );
        System.out.println("Mensagem enviada para o exchange: " + clienteMessage);
    }
}
