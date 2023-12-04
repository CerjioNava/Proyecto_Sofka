package EPA.Cuenta_Bancaria_Web.Repositorio;

import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cuenta_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_ClienteMongo;
import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_CuentaMongo;
import EPA.Cuenta_Bancaria_Web.Repositorio.Mongo.I_RepositorioCuentaMongo;
import EPA.Cuenta_Bancaria_Web.Repositorio.Mongo.I_Repositorio_TransaccionMongo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.util.Assert;

@DataMongoTest
public class TestRepositorioMongo
{
    @Autowired
    private I_RepositorioCuentaMongo repositorioCuenta;

    @Autowired
    private I_Repositorio_TransaccionMongo repositorioTransaccion;


    @Test
    @DisplayName("Obtener una cuenta especifica")
    public void testObtenerCuentaCreada()
    {
        // Fase 1. Guardar un documento en la base de datos embebida
        repositorioCuenta.save(new M_CuentaMongo("C1",
                                                 new M_ClienteMongo("u1", "Alexander"),
                                                 BigDecimal.valueOf(100)
                                                )
                              );

        //  Buscar el documento por su identificador
        Optional<M_CuentaMongo> cuentaBuscada = repositorioCuenta.findById("C1");

       // Hago verificaciones
       assert(cuentaBuscada.isPresent());
       assert(cuentaBuscada.get().getId().equals("C1"));
    }


}
