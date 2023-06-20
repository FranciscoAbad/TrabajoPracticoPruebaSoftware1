package unla.oo2.grupo24.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_banio")
public class Banio extends Dispositivo {
	
	@Column(name="higienizado",nullable=false)
	private boolean higienizado;
	
	@Column(name="zona",length=60,nullable=false)
	private String zona;
	
	@Column(name="sexo",length=60,nullable=false)
	private String sexo;
	
	
	public Banio() {}

	


	public Banio(boolean higienizado, String zona, String sexo) {
		super();
		this.higienizado = higienizado;
		this.zona = zona;
		this.sexo = sexo;
	}




	public String getSexo() {
		return sexo;
	}




	public void setSexo(String sexo) {
		this.sexo = sexo;
	}




	public boolean isHigienizado() {
		return higienizado;
	}

	public void setHigienizado(boolean higienizado) {
		this.higienizado = higienizado;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}




	
	

}
