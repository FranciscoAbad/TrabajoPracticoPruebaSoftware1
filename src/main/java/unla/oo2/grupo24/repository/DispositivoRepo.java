package unla.oo2.grupo24.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.oo2.grupo24.Entity.Dispositivo;

@Repository
public interface DispositivoRepo extends JpaRepository<Dispositivo,Long> {

}
