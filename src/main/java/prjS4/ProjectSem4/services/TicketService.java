package prjS4.ProjectSem4.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Tickets;
import prjS4.ProjectSem4.interfaces.ITicketService;
import prjS4.ProjectSem4.repositories.TicketRepository;

@Service
public class TicketService implements ITicketService {
    
    @Autowired
    private TicketRepository ticketRepository;

     @Override
    public List<Tickets> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Tickets getTicketById(String id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public Tickets createTicket(Tickets ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Tickets updateTicket(String id, Tickets ticketDetails) {
        Tickets existingTicket = ticketRepository.findById(id).orElse(null);
        if (existingTicket != null) {
            existingTicket.setTicketStatus(ticketDetails.getTicketStatus());
            existingTicket.setFareId(ticketDetails.getFareId());
            existingTicket.setSeatId(ticketDetails.getSeatId());
            existingTicket.setShiftId(ticketDetails.getShiftId());
            return ticketRepository.save(existingTicket);
        }
        return null;
    }

    @Override
    public boolean deleteTicket(String id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Tickets> getTicketsByShift(String shiftId) {
        return ticketRepository.findByShiftId(shiftId);
    }

    @Override
    public List<Tickets> getTicketsByFare(String fareId) {
        return ticketRepository.findByFareId(fareId);
    }

    @Override
    public List<Tickets> getTicketsBySeat(String seatId) {
        return ticketRepository.findBySeatId(seatId);
    }
    
}
