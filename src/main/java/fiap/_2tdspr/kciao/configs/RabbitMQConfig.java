package fiap._2tdspr.kciao.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import java.util.Map;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "clienteQueue";
    public static final String EXCHANGE_NAME = "clienteExchange";
    public static final String ROUTING_KEY = "clienteKey";

    @Bean
    public Queue clienteQueue() {
        return new Queue(QUEUE_NAME, true, false, false, Map.of("x-queue-type", "classic"));
    }

    @Bean
    public FanoutExchange clienteExchange() {
        return new FanoutExchange(EXCHANGE_NAME);  // Fanout Exchange
    }

    @Bean
    public Binding binding(Queue clienteQueue, FanoutExchange clienteExchange) {
        return BindingBuilder.bind(clienteQueue).to(clienteExchange);  // Binding Queue to Exchange
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}
