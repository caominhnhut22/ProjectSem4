package prjS4.ProjectSem4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prjS4.ProjectSem4.entities.Seats;

public interface SeatRepository extends JpaRepository<Seats, String> {
    
}
