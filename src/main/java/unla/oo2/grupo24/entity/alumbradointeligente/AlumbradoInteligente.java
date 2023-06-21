package unla.oo2.grupo24.entity.alumbradointeligente;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import unla.oo2.grupo24.entity.Dispositivo;

@Entity
@Table(name = "alumbrado_inteligente")
@DiscriminatorValue(value = "alumbrado_inteligente")
public class AlumbradoInteligente extends Dispositivo {
    private boolean encendido;

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
}
