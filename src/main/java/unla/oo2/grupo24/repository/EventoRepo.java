package unla.oo2.grupo24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.entity.SensorEstacionamiento;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface EventoRepo extends JpaRepository<Evento, Serializable> {

}
