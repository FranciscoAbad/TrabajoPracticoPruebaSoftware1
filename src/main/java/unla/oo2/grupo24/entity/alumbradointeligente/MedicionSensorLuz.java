package unla.oo2.grupo24.entity.alumbradointeligente;

import unla.oo2.grupo24.entity.Medicion;

public class MedicionSensorLuz extends Medicion {
    private boolean estadoLuz;

    public boolean isEstadoLuz() {
        return estadoLuz;
    }

    public void setEstadoLuz(boolean estadoLuz) {
        this.estadoLuz = estadoLuz;
    }
    
}
