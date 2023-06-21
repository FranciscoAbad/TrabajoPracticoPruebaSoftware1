package unla.oo2.grupo24.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import unla.oo2.grupo24.entity.Banio;

import unla.oo2.grupo24.entity.Dispositivo;

@Repository
public interface DispositivoRepo extends JpaRepository<Dispositivo,Long> {


	@Query("SELECT b FROM Banio b")
    List<Banio> findAllBanio();
	
}
