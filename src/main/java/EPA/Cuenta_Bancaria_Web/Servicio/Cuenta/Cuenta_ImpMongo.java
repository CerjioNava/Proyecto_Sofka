package EPA.Cuenta_Bancaria_Web.Servicio.Cuenta;

import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cliente_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cuenta_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_ClienteMongo;
import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_CuentaMongo;
import EPA.Cuenta_Bancaria_Web.Repositorio.Mongo.I_RepositorioCuentaMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("MONGO")
public class Cuenta_ImpMongo implements I_Cuenta
{
    @Autowired
    I_RepositorioCuentaMongo repositorio_Cuenta;

    @Override
    public Mono<M_Cuenta_DTO> crear_Cuenta(M_Cuenta_DTO p_Cuenta_DTO)
    {
        return repositorio_Cuenta
                .save(new M_CuentaMongo(
                        p_Cuenta_DTO.getId(),
                        new M_ClienteMongo(p_Cuenta_DTO.getCliente().getId(),
                        p_Cuenta_DTO.getCliente().getNombre()),
                        p_Cuenta_DTO.getSaldo_Global()))
                .map(cuenta_Creada ->
                        new M_Cuenta_DTO(
                            cuenta_Creada.getId(),
                            new M_Cliente_DTO(cuenta_Creada.getCliente().getId(),
                            cuenta_Creada.getCliente().getNombre()),
                            cuenta_Creada.getSaldo_Global())
                );
    }

    @Override
    public Flux<M_Cuenta_DTO> findAll()
    {
        return repositorio_Cuenta.findAll()
                .map(cuenta ->
                        new M_Cuenta_DTO(
                            cuenta.getId(),
                            new M_Cliente_DTO(cuenta.getCliente().getId(),
                            cuenta.getCliente().getNombre()),
                            cuenta.getSaldo_Global())
                );
    }
}
