package EPA.Cuenta_Bancaria_Web.Servicio.RabbitMQ;

import EPA.Cuenta_Bancaria_Web.MQConfig;
import EPA.Cuenta_Bancaria_Web.Modelo.DTO.RabbitMessage_DTO;
import com.rabbitmq.client.AMQP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.OutboundMessage;
import reactor.rabbitmq.QueueSpecification;
import reactor.rabbitmq.Sender;

@Service
@Qualifier("rabbit")
public class SenderServiceImpl implements ISenderService {

    @Autowired
    private Sender sender;

    public SenderServiceImpl(Sender sender) {
        this.sender = sender;
    }

    // Declarar una cola con el nombre dado
//    public Mono<AMQP.Queue.DeclareOk> declareQueue(String queueName) {
//        return sender.declareQueue(QueueSpecification.queue(queueName));
//    }

    // Enviar un mensaje a la cola con el contenido dado
    public Mono<Void> sendMessage(RabbitMessage_DTO dto) {
        System.out.println("ENVIANDO MENSAJE");
        System.out.println(dto);

        sender
            .send(Mono.just(new OutboundMessage(dto.getExchangeName(), MQConfig.ROUTING_KEY, dto.getContent().getBytes())))
            .subscribe();

        return closeSender();
    }

    // Cerrar el sender al terminar
    public Mono<Void> closeSender() {
        sender.close();
        return null;
    }




}
