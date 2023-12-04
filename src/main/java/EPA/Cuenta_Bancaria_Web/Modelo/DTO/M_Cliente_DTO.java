package EPA.Cuenta_Bancaria_Web.Modelo.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class M_Cliente_DTO
{
    @NotNull(message = "[CLIENTE] [id] Campo Requerido: Id.")
    private String id;

    @NotNull(message = "[CLIENTE] [nombre] Campo Requerido: Id.")
    private String nombre;

    public M_Cliente_DTO(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
