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
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_evento",nullable=false)
	private long id_evento;
	
	@Column(name="fecha",length=60,nullable=false)
	private LocalDate fecha;
	
	@Column(name="descripcion",length=60,nullable=false)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="id_dispositivo")
	Dispositivo dispositivo;
	
	public Evento() {}

	public Evento(LocalDate fecha, String descripcion) {
		super();
		this.fecha = fecha;
		descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		descripcion = descripcion;
	}

	public long getId() {
		return id_evento;
	}

	public void setId(long id) {
		this.id_evento = id;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	

}
