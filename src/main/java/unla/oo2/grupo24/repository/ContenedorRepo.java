package unla.oo2.grupo24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unla.oo2.grupo24.entity.Contenedor;

@Repository
public interface ContenedorRepo extends JpaRepository<Contenedor,Long>  {

}
