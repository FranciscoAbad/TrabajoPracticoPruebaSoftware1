package unla.oo2.grupo24.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import unla.oo2.grupo24.entity.MedicionBanio;

@Repository
public interface IMedicionBanio  extends JpaRepository<MedicionBanio, Serializable>{ 
	 @Query("select s from MedicionBanio s")
	   List<MedicionBanio> findAllMedicionBanio();

}
