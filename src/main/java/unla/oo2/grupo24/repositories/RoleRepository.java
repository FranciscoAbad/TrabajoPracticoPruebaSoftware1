package unla.oo2.grupo24.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unla.oo2.grupo24.entities.UserRole;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Serializable> {

    Optional<UserRole> findByRole(String role);
}
