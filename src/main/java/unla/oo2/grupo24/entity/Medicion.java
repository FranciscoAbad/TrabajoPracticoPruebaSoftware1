package unla.oo2.grupo24.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Medicion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_medicion",nullable=false)
	private long id_medicion;
	
	@Column(name="fecha",length=60,nullable=false)
	private LocalDate fecha;
	
	@Column(name="datos",length=60,nullable=false)
	private String datos;
	
	@ManyToOne
	@JoinColumn(name="id_dispositivo")
	Dispositivo dispositivo;
	
	public Medicion() {}

	public Medicion(LocalDate fecha, String datos) {
		super();
		this.fecha = fecha;
		this.datos = datos;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	public long getId() {
		return id_medicion;
	}

	public void setId(long id) {
		this.id_medicion = id;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	
	
	

}