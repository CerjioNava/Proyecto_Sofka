package EPA.Cuenta_Bancaria_Web.Servicio.Transaccion;

import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Transaccion_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.Enum_Tipos_Deposito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;

public interface I_Transaccion
{
    Mono<M_Transaccion_DTO> Procesar_Deposito(String id_Cuenta, Enum_Tipos_Deposito tipo, BigDecimal monto);

    Flux<M_Transaccion_DTO> findAll();
}
