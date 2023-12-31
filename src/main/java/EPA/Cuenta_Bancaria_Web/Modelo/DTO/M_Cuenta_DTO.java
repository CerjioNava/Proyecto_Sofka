package EPA.Cuenta_Bancaria_Web.Modelo.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class M_Cuenta_DTO
{
    //@NotNull(message = "[CUENTA] [id] Campo Requerido: Id.")
    private String id;

    @Valid
    @NotNull(message = "[CUENTA] [Cliente] Campo Requerido: La Cuenta debe poseer información del Cliente.")
    private M_Cliente_DTO cliente;

    @DecimalMin(value = "0.00", inclusive = true, message = "[CUENTA] [saldo_Global] El Saldo Inicial deber ser mayor o igual a 0.00")
    @DecimalMax(value = "1000000.00", inclusive = true, message = "[CUENTA] [saldo_Global] El Saldo Inicial deber ser menor o igual a 1000000.00")
    //@Digits(integer = 7, fraction = 2, message = "[CUENTA] [saldo_Global] El Formato del Saldo debe ser 7 digitos enteros y 2 decimales")
    private BigDecimal saldo_Global;



    public M_Cuenta_DTO(String id, M_Cliente_DTO cliente, BigDecimal saldo_Global) {
        this.id = id;
        this.cliente = cliente;
        this.saldo_Global = saldo_Global;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public M_Cliente_DTO getCliente() {
        return cliente;
    }

    public void setCliente(M_Cliente_DTO cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSaldo_Global() {
        return saldo_Global;
    }

    public void setSaldo_Global(BigDecimal saldo_Global) {
        this.saldo_Global = saldo_Global;
    }
}
