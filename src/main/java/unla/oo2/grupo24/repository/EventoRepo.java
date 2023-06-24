package unla.oo2.grupo24.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import unla.oo2.grupo24.entity.Evento;

@Repository
public interface EventoRepo extends JpaRepository<Evento, Serializable> {

    @Query(value = "SELECT e.* FROM Evento e JOIN Dispositivo d ON e.id_dispositivo = d.id_dispositivo WHERE d.tipo_dispositivo = :tipoDispositivo", nativeQuery = true)
    List<Evento> findByTipe(@Param("tipoDispositivo") String tipoDispositivo);

}
