package EPA.Cuenta_Bancaria_Web.Controlador;

import EPA.Cuenta_Bancaria_Web.Modelo.DTO.RabbitMessage_DTO;
import EPA.Cuenta_Bancaria_Web.Servicio.RabbitMQ.ISenderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("rabbit")
public class RabbitController {

    @Autowired
    @Qualifier("rabbit")
    ISenderService iSenderService;

    @PostMapping(value = "/test")
    public Mono<Void> rabbit_test(@Valid @RequestBody RabbitMessage_DTO dto)
    {
        return iSenderService.sendMessage(dto);
    }
}
