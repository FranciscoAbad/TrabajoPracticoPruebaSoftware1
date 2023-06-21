package unla.oo2.grupo24.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "id_medicion")
public class MedicionEstacionamiento extends Medicion {

    @Column(name="plaza_ocupada",nullable = false)
    private boolean plazaOcupada;

    public MedicionEstacionamiento() {
        super();
    }



    public MedicionEstacionamiento(LocalDateTime fechaHora, Dispositivo dispositivo, boolean plazaOcupada) {
        super(fechaHora, dispositivo);
        this.plazaOcupada = plazaOcupada;
    }

    public boolean isPlazaOcupada() {
        return plazaOcupada;
    }

    public void setPlazaOcupada(boolean plazaOcupada) {
        this.plazaOcupada = plazaOcupada;
    }
}
