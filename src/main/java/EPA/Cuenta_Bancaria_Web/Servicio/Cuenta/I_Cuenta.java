package EPA.Cuenta_Bancaria_Web.Servicio.Cuenta;

import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cuenta_DTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface I_Cuenta
{
    Mono<M_Cuenta_DTO> crear_Cuenta(M_Cuenta_DTO p_Cuenta);

    Flux<M_Cuenta_DTO> findAll();
}
