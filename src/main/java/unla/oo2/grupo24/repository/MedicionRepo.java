package unla.oo2.grupo24.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import unla.oo2.grupo24.entity.Medicion;

public interface MedicionRepo extends JpaRepository<Medicion,Serializable>{

}