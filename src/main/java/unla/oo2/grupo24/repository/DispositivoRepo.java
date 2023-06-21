package unla.oo2.grupo24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import unla.oo2.grupo24.entity.Dispositivo;
import unla.oo2.grupo24.entity.SensorEstacionamiento;

import java.util.List;

@Repository
public interface DispositivoRepo extends JpaRepository<Dispositivo,Long> {


@Query("select s from SensorEstacionamiento s")
    List<SensorEstacionamiento> findAllSensorEstacionamiento();
}
