package unla.oo2.grupo24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "id_estacionamiento")
public class SensorEstacionamiento extends Dispositivo {

    @Column(name="estado_actual", nullable = false)
    private boolean estadoActual;

    public SensorEstacionamiento() {
        super();
    }


    public SensorEstacionamiento(String nombre, String descripcion, boolean activo, LocalDate fecha, boolean estadoActual) {
        super(nombre, descripcion, activo, fecha);
        this.estadoActual = estadoActual;

    }

    public boolean isEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(boolean estadoActual) {
        this.estadoActual = estadoActual;
    }
}
