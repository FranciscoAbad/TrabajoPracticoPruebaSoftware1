package unla.oo2.grupo24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unla.oo2.grupo24.entity.SensorLuzInteligente;

@Repository
public interface SensorLuzInteligenteRepository extends JpaRepository<SensorLuzInteligente, Long> {
}
