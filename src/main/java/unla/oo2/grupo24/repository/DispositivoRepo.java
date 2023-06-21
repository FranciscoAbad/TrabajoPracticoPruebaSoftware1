package unla.oo2.grupo24.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import unla.oo2.grupo24.entity.Dispositivo;
import unla.oo2.grupo24.entity.SensorEstacionamiento;
import unla.oo2.grupo24.entity.alumbradointeligente.AlumbradoInteligente;

@Repository
public interface DispositivoRepo extends JpaRepository<Dispositivo,Long> {

    @Query("SELECT a FROM AlumbradoInteligente a")
    List<AlumbradoInteligente> findAllAlumbradoInteligente();


@Query("select s from SensorEstacionamiento s")
    List<SensorEstacionamiento> findAllSensorEstacionamiento();
}
