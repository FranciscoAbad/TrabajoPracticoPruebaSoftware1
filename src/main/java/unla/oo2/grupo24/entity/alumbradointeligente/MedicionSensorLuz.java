package unla.oo2.grupo24.entity.alumbradointeligente;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import unla.oo2.grupo24.entity.Dispositivo;
import unla.oo2.grupo24.entity.Medicion;

@Entity
@Table(name = "medicion_sensor_luz")
public class MedicionSensorLuz extends Medicion {
    private boolean estadoLuz;

    public boolean isEstadoLuz() {
        return estadoLuz;
    }

    public void setEstadoLuz(boolean estadoLuz) {
        this.estadoLuz = estadoLuz;
    }

      public MedicionSensorLuz(LocalDateTime fechaHora, Dispositivo dispositivo, boolean estadoLuz) {
        super(fechaHora, dispositivo);
        this.estadoLuz = estadoLuz;
    }
}
