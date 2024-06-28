package prjS4.ProjectSem4.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import prjS4.ProjectSem4.entities.Invoices;
import prjS4.ProjectSem4.entities.Tickets;
import prjS4.ProjectSem4.interfaces.IInvoiceService;
import prjS4.ProjectSem4.interfaces.ITicketService;

@RestController
@RequestMapping("/api/booking")
public class BillAPI {
    
    @Autowired
    private IInvoiceService invoiceService;

    @Autowired
    private ITicketService ticketService;

    // Invoices endpoints

    @GetMapping("/invoices")
    @PreAuthorize("hasRole('USER')")
    public List<Invoices> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/invoices/{id}")
    @PreAuthorize("hasRole('USER')")
    public Invoices getInvoiceById(@PathVariable String id) {
        return invoiceService.getInvoiceById(id);
    }

    @PostMapping("/invoices")
    @PreAuthorize("hasRole('ADMIN')")
    public Invoices createInvoice(@RequestBody Invoices invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @PutMapping("/invoices/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Invoices updateInvoice(@PathVariable String id, @RequestBody Invoices invoice) {
        return invoiceService.updateInvoice(id, invoice);
    }

    @DeleteMapping("/invoices/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteInvoice(@PathVariable String id) {
        invoiceService.deleteInvoice(id);
    }

    // Tickets endpoints

    @GetMapping("/tickets")
    @PreAuthorize("hasRole('USER')")
    public List<Tickets> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/tickets/{id}")
    @PreAuthorize("hasRole('USER')")
    public Tickets getTicketById(@PathVariable String id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping("/tickets")
    @PreAuthorize("hasRole('ADMIN')")
    public Tickets createTicket(@RequestBody Tickets ticket) {
        return ticketService.createTicket(ticket);
    }

    @PutMapping("/tickets/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Tickets updateTicket(@PathVariable String id, @RequestBody Tickets ticket) {
        return ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/tickets/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTicket(@PathVariable String id) {
        ticketService.deleteTicket(id);
    }
    
}
