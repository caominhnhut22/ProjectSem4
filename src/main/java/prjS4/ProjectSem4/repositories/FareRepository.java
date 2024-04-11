package prjS4.ProjectSem4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prjS4.ProjectSem4.entities.Fares;

public interface FareRepository extends JpaRepository<Fares, String> {
    
}
