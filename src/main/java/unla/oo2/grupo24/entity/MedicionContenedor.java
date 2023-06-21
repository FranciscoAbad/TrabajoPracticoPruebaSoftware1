package unla.oo2.grupo24.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name= "medicion_sensor_contenedor")
public class MedicionContenedor extends Medicion{
    private boolean contenedorLLeno;

    public MedicionContenedor(LocalDateTime fechaHora, Dispositivo dispositivo, boolean contenedorLLeno) {
        super(fechaHora, dispositivo);
        this.contenedorLLeno = contenedorLLeno;
    }

    public boolean isContenedorLLeno() {
        return contenedorLLeno;
    }

    public void setContenedorLLeno(boolean contenedorLLeno) {
        this.contenedorLLeno = contenedorLLeno;
    }
}
