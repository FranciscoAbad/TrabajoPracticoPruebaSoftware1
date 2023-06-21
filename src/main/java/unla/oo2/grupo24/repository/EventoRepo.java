package unla.oo2.grupo24.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.oo2.grupo24.entity.Evento;

@Repository
public interface EventoRepo extends JpaRepository<Evento, Serializable> {

}
