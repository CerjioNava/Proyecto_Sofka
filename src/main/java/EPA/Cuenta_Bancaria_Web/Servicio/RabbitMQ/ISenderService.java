package EPA.Cuenta_Bancaria_Web.Servicio.RabbitMQ;

import EPA.Cuenta_Bancaria_Web.Modelo.DTO.RabbitMessage_DTO;
import com.rabbitmq.client.AMQP;
import reactor.core.publisher.Mono;

public interface ISenderService
{
//    // Declarar una cola con el nombre dado
//    Mono<AMQP.Queue.DeclareOk> declareQueue(String queueName);

    // Enviar un mensaje a la cola con el contenido dado
    Mono<Void> sendMessage(RabbitMessage_DTO dto);

    // Cerrar el sender al terminar
//    Mono<Void> closeSender();
}
