package fiap._2tdspr.kciao.usecases.services.messaging;

import com.rabbitmq.client.Channel;
import fiap._2tdspr.kciao.gateways.responses.cliente.ClienteResponseDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsumerService {

    @RabbitListener(queues = "clienteQueue")
    public void receiveMessage(ClienteResponseDto message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException, InterruptedException {
        Thread.sleep(5000); // Delay de 5 segundos

        try {
            System.out.println("Processando: " + message);
            channel.basicAck(tag, false); // Confirma processamento
        } catch (Exception e) {
            channel.basicNack(tag, false, true); // Reenvia para a fila em caso de erro
        }
    }
}
