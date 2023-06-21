package unla.oo2.grupo24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import unla.oo2.grupo24.entity.Contenedor;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.entity.Medicion;
import unla.oo2.grupo24.entity.MedicionContenedor;

import java.io.Serializable;
import java.util.List;

@Repository
public interface MedicionRepo extends JpaRepository<Medicion, Serializable>{
    @Query("SELECT c FROM MedicionContenedor c")
    List<MedicionContenedor> findAllMedicionContenedor();

}