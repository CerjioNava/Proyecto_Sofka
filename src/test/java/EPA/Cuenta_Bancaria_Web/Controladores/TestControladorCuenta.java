package EPA.Cuenta_Bancaria_Web.Controladores;

import EPA.Cuenta_Bancaria_Web.Controlador.C_Cuenta;
import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cliente_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cuenta_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_ClienteMongo;
import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_CuentaMongo;
import EPA.Cuenta_Bancaria_Web.Servicio.Cuenta.Cuenta_ImpMongo;
import EPA.Cuenta_Bancaria_Web.Servicio.Cuenta.I_Cuenta;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(value = C_Cuenta.class) // M_CuentaMongo
public class TestControladorCuenta
{
    // USANDO WEBMVCTEST
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("MONGO")
    private I_Cuenta serviciCuentaMongo;

    @Test
    public void a() throws Exception
    {
        Mockito.when(serviciCuentaMongo.findAll()).thenReturn(
                new ArrayList<M_Cuenta_DTO>(
                        List.of(
                                new M_Cuenta_DTO("1",
                                        new M_Cliente_DTO("1", "Alexander"),
                                        BigDecimal.valueOf(1000000))
                        )
                )
        );

        mockMvc.perform(get("http://localhost:8086/Cuentas/listar_cuentas"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("[{\"id\":\"8\",\"cliente\":{\"id\":\"1\",\"nombre\":\"Alexander\"},\"saldo_Global\":1508.00}]"));

    }

}
