package prjS4.ProjectSem4.interfaces;

import java.util.List;
import prjS4.ProjectSem4.entities.Seats;

public interface ISeatService {
    
    List<Seats> getAllSeats();
    
    Seats getSeatById(String id);
    
    Seats createSeat(Seats seat);
    
    Seats updateSeat(String id, Seats seat);
    
    void deleteSeat(String id);
    
}
