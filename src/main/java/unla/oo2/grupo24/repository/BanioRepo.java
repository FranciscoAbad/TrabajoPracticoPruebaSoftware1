package unla.oo2.grupo24.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.oo2.grupo24.Entity.Banio;

@Repository
public interface BanioRepo extends JpaRepository<Banio,Long>  {

}
