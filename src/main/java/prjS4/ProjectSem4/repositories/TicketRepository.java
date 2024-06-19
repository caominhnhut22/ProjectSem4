package prjS4.ProjectSem4.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import prjS4.ProjectSem4.entities.Tickets;

public interface TicketRepository extends JpaRepository<Tickets, String> {
    
    List<Tickets> findByShiftId(String shiftId);
    List<Tickets> findByFareId(String fareId);
    List<Tickets> findBySeatId(String seatId);
    
}
