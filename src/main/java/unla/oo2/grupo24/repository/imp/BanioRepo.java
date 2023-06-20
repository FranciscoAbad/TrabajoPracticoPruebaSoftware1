package unla.oo2.grupo24.repository.imp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.oo2.grupo24.entity.Banio;

@Repository
public interface BanioRepo extends JpaRepository<Banio,Long>  {

}
