package prjS4.ProjectSem4.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import prjS4.ProjectSem4.entities.Tickets;

public interface TicketRepository extends JpaRepository<Tickets, String> {
    
    List<Tickets> findByShiftId_ShiftId(String shiftId);
    
    List<Tickets> findByFareId_FareId(String fareId);
    
    List<Tickets> findBySeatId_SeatId(String seatId);
    
}
