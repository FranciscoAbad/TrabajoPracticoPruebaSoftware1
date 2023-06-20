package unla.oo2.grupo24.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "luz_inteligente")
public class SensorLuzInteligente extends Dispositivo {

    private boolean estadoLuz;

    public boolean isEstadoLuz() {
        return estadoLuz;
    }

    public void setEstadoLuz(boolean estadoLuz) {
        this.estadoLuz = estadoLuz;
    }

    public SensorLuzInteligente(boolean estadoLuz) {
        super();
        this.estadoLuz = estadoLuz;
    }

    public SensorLuzInteligente() {
    }

}
