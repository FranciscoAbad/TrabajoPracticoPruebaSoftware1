package unla.oo2.grupo24.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import unla.oo2.grupo24.entity.Medicion;
import unla.oo2.grupo24.entity.MedicionEstacionamiento;
import unla.oo2.grupo24.entity.alumbradointeligente.MedicionSensorLuz;

@Repository
public interface MedicionRepo extends JpaRepository<Medicion, Serializable>{
    @Query("select s from MedicionEstacionamiento s")
    List<MedicionEstacionamiento> findAllMedicionEstacionamiento();

    @Query("select s from MedicionSensorLuz s")
    List<MedicionSensorLuz> findAllMedicionSensorLuz();
}
