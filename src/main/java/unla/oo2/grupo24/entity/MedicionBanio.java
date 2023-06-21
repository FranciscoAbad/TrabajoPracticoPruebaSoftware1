package unla.oo2.grupo24.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
public class MedicionBanio extends Medicion {
	 
	@Column(name="esta_higienizado",nullable = false)
	    private boolean estaHigienizado;
	
	 public MedicionBanio() {
	        super();
	    }

	 public MedicionBanio(LocalDateTime fechaHora, Dispositivo dispositivo, boolean estaHigienizado) {
	        super(fechaHora, dispositivo);
	        this.estaHigienizado = estaHigienizado;
	    }

	public boolean isEstaOcupado() {
		return estaHigienizado;
	}

	public void setEstaOcupado(boolean estaOcupado) {
		this.estaHigienizado = estaOcupado;
	}
	 

}
