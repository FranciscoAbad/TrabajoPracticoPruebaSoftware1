package unla.oo2.grupo24.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
	private long idEvento;

	@Column(name="fechaHora",length=60,nullable=false)
	private LocalDateTime fechaHora;
	
	@Column(name="descripcion",length=60,nullable=false)
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="id_dispositivo")
	Dispositivo dispositivo;
	
	public Evento() {}

	public Evento(LocalDateTime fechaHora, String descripcion) {
		super();
		this.fechaHora = fechaHora;
		descripcion = descripcion;
	}

	public LocalDateTime getFecha() {
		return fechaHora;
	}

	public void setFecha(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		descripcion = descripcion;
	}

	public long getId() {
		return idEvento;
	}

	public void setId(long id) {
		this.idEvento = id;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	

}
