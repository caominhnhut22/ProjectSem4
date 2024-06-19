package prjS4.ProjectSem4.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import prjS4.ProjectSem4.entities.Tickets;
import prjS4.ProjectSem4.interfaces.ITicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketAPI {

    @Autowired
    private ITicketService ticketService;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN', 'MANAGEMENT_EMPLOYEE', 'EMPLOYEE')")
    public ResponseEntity<List<Tickets>> getAllTickets() {
        List<Tickets> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok().body(tickets);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN', 'MANAGEMENT_EMPLOYEE', 'EMPLOYEE', 'USER', 'COMPLETED_USER')")
    public ResponseEntity<Tickets> getTicketById(@PathVariable(value = "id") String ticketId) {
        Tickets ticket = ticketService.getTicketById(ticketId);
        if (ticket == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(ticket);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<Tickets> createTicket(@RequestBody Tickets ticket) {
        Tickets createdTicket = ticketService.createTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<Tickets> updateTicket(
            @PathVariable(value = "id") String ticketId,
            @RequestBody Tickets ticketDetails) {
        Tickets updatedTicket = ticketService.updateTicket(ticketId, ticketDetails);
        if (updatedTicket == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedTicket);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN')")
    public ResponseEntity<Void> deleteTicket(@PathVariable(value = "id") String ticketId) {
        boolean deleted = ticketService.deleteTicket(ticketId);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/byShift/{shiftId}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN', 'MANAGEMENT_EMPLOYEE', 'EMPLOYEE', 'USER', 'COMPLETED_USER')")
    public ResponseEntity<List<Tickets>> getTicketsByShift(@PathVariable(value = "shiftId") String shiftId) {
        List<Tickets> tickets = ticketService.getTicketsByShift(shiftId);
        return ResponseEntity.ok().body(tickets);
    }

    @GetMapping("/byFare/{fareId}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN', 'MANAGEMENT_EMPLOYEE', 'EMPLOYEE', 'USER', 'COMPLETED_USER')")
    public ResponseEntity<List<Tickets>> getTicketsByFare(@PathVariable(value = "fareId") String fareId) {
        List<Tickets> tickets = ticketService.getTicketsByFare(fareId);
        return ResponseEntity.ok().body(tickets);
    }

    @GetMapping("/bySeat/{seatId}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN', 'MANAGEMENT_EMPLOYEE', 'EMPLOYEE', 'USER', 'COMPLETED_USER')")
    public ResponseEntity<List<Tickets>> getTicketsBySeat(@PathVariable(value = "seatId") String seatId) {
        List<Tickets> tickets = ticketService.getTicketsBySeat(seatId);
        return ResponseEntity.ok().body(tickets);
    }
    
}