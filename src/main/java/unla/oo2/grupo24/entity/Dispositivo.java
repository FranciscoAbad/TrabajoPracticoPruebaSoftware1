package unla.oo2.grupo24.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@DiscriminatorColumn(name="tipo_dispositivo")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_dispositivo")
public class Dispositivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_dispositivo",nullable=false)
	private long idDispositivo;
	
	@Column(name="nombre",length=60,nullable=false)
	private String nombre;
	
	@Column(name="descripcion",length=60,nullable=false)
	private String descripcion;
	
	
	@Column(name="activo",length=60,nullable=false)
	private boolean activo;

	@Column(name="fecha",length=60,nullable=false)
	private LocalDate fecha;
	
	@OneToMany(mappedBy="dispositivo")
	private List<Evento> eventos = new ArrayList<Evento>();
	
	@OneToMany(mappedBy="dispositivo")
	private List<Medicion> mediciones = new ArrayList<Medicion>();

	public Dispositivo() {}

	public Dispositivo(String nombre, String descripcion, boolean activo, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.fecha = fecha;
	}

	public long getIdDispositivo() {
		return idDispositivo;
	}

	public void setIdDispositivo(long idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public long getidDispositivo() {
		return idDispositivo;
	}

	public void setidDispositivo(long idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Medicion> getMediciones() {
		return mediciones;
	}

	public void setMediciones(List<Medicion> mediciones) {
		this.mediciones = mediciones;
	}

	public void agregarEvento(Evento e){
		e.setDispositivo(this);
		this.eventos.add(e);
	}

	public void agregarMedicion(Medicion e){
		e.setDispositivo(this);
		this.mediciones.add(e);
	}


	@Override
	public String toString() {
		return "Dispositivo{" +
				"idDispositivo=" + idDispositivo +
				", nombre='" + nombre + '\'' +
				", descripcion='" + descripcion + '\'' +
				", activo=" + activo +
				", fecha=" + fecha +
				", eventos=" + eventos +
				", mediciones=" + mediciones +
				'}';
	}
}
