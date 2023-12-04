package EPA.Cuenta_Bancaria_Web.Servicios;

import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cuenta_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_ClienteMongo;
import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_CuentaMongo;
import EPA.Cuenta_Bancaria_Web.Repositorio.Mongo.I_RepositorioCuentaMongo;
import EPA.Cuenta_Bancaria_Web.Servicio.Cuenta.Cuenta_ImpMongo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class TestServicioCuenta
{
    // Inyectar un objeto simulado de MiServicio
    @InjectMocks
    //@Qualifier("JPA")
    Cuenta_ImpMongo servicioCuenta;

    // Crear un objeto simulado de MiRepositorio
    @Mock
    I_RepositorioCuentaMongo miRepositorio;

    @Test
    @DisplayName("Buscar Todas Las Cuentas")
    public void BuscarTodasLasCuentas()
    {
        Mockito.when(miRepositorio.findAll()).thenReturn(
                                                            new ArrayList<M_CuentaMongo>(
                                                                    List.of(
                                                                            new M_CuentaMongo("1",
                                                                                    new M_ClienteMongo("1", "Alexander"),
                                                                                    BigDecimal.valueOf(1000000))
                                                                           )
                                                                                       )
                                                        );

        List<M_Cuenta_DTO> listaCuentas = servicioCuenta.findAll();

        assert(listaCuentas.size() == 1);

    }

}
