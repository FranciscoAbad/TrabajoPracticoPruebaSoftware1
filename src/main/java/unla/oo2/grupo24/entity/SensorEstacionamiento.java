package unla.oo2.grupo24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "id_estacionamiento")
public class SensorEstacionamiento extends Dispositivo {

    public SensorEstacionamiento(){
        super();
    }


    public SensorEstacionamiento(String nombre, String descripcion, boolean activo, LocalDate fecha, boolean plazasLibres) {
        super(nombre, descripcion, activo, fecha);
        this.plazasLibres = plazasLibres;
    }

    @Column(name="plazasLibres",nullable=false)
    private boolean plazasLibres;

    public SensorEstacionamiento(boolean plazasLibres) {
        this.plazasLibres = plazasLibres;
    }

    public boolean isPlazasLibres() {
        return plazasLibres;
    }

    public void setPlazasLibres(boolean plazasLibres) {
        this.plazasLibres = plazasLibres;
    }

    @Override
    public String toString() {
        return "SensorEstacionamiento{" +
                "plazasLibres=" + plazasLibres +
                '}';
    }
}
