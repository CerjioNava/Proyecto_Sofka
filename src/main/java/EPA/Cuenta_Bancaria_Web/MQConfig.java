package EPA.Cuenta_Bancaria_Web;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Delivery;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.*;

import java.net.URI;

@Configuration
public class MQConfig {

    public static final String QUEUE_NAME = "queue_test";
    public static final String TOPIC_NAME = "exchange_test";
    public static final String ROUTING_KEY = "routing_test";

    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.port}")
    private String port;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;

    @Autowired
    Mono<Connection> connectionMono;
    @Autowired
    AmqpAdmin amqpAdmin;

    @Bean
    public AmqpAdmin amqpAdmin() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        var amqpAdmin =  new RabbitAdmin(connectionFactory);

        var exchange = new TopicExchange(TOPIC_NAME);
        var queue = new Queue(QUEUE_NAME, true, false, false);

        amqpAdmin.declareExchange(exchange);
        amqpAdmin.declareQueue(queue);

        amqpAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY));

        return amqpAdmin;
    }

    // Bien
    @Bean
    Mono<Connection> connectionMono() {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost(host);
        connectionFactory.setPort(Integer.parseInt(port));
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return Mono.fromCallable(() -> connectionFactory.newConnection(TOPIC_NAME)).cache();
    }

    @Bean
    Sender sender(Mono<Connection> connectionMono) {
        return RabbitFlux.createSender(new SenderOptions().connectionMono(connectionMono));
    }

    @Bean
    Receiver receiver(Mono<Connection> connectionMono) {
        return RabbitFlux.createReceiver(new ReceiverOptions().connectionMono(connectionMono));
    }

    @Bean
    Flux<Delivery> deliveryFlux(Receiver receiver) {
        return receiver.consumeNoAck(QUEUE_NAME);
    }



}
