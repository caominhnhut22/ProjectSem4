package prjS4.ProjectSem4.interfaces;

import java.util.List;
import prjS4.ProjectSem4.entities.Tickets;

public interface ITicketService {
    
    List<Tickets> getAllTickets();
    
    Tickets getTicketById(String id);
    
    Tickets createTicket(Tickets ticket);
    
    Tickets updateTicket(String id, Tickets ticketDetails);
    
    boolean deleteTicket(String id);
    
    List<Tickets> getTicketsByShift(String shiftId);
    
    List<Tickets> getTicketsByFare(String fareId);
    
    List<Tickets> getTicketsBySeat(String seatId);
    
}
