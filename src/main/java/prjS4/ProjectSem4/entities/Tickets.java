package prjS4.ProjectSem4.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Tickets")
@NamedQueries({
    @NamedQuery(name = "Tickets.findAll", query = "SELECT t FROM Tickets t"),
    @NamedQuery(name = "Tickets.findByTicketId", query = "SELECT t FROM Tickets t WHERE t.ticketId = :ticketId"),
    @NamedQuery(name = "Tickets.findByTicketStatus", query = "SELECT t FROM Tickets t WHERE t.ticketStatus = :ticketStatus")})
public class Tickets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private String ticketId;
    @Column(name = "ticket_status")
    private Integer ticketStatus;
    @OneToMany(mappedBy = "ticketId")
    private List<Invoices> invoicesList;
    @JoinColumn(name = "fare_id", referencedColumnName = "fare_id")
    @ManyToOne
    private Fares fareId;
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id")
    @ManyToOne
    private Seats seatId;
    @JoinColumn(name = "shift_id", referencedColumnName = "shift_id")
    @ManyToOne
    private Shifts shiftId;

    public Tickets() {
    }

    public Tickets(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public List<Invoices> getInvoicesList() {
        return invoicesList;
    }

    public void setInvoicesList(List<Invoices> invoicesList) {
        this.invoicesList = invoicesList;
    }

    public Fares getFareId() {
        return fareId;
    }

    public void setFareId(Fares fareId) {
        this.fareId = fareId;
    }

    public Seats getSeatId() {
        return seatId;
    }

    public void setSeatId(Seats seatId) {
        this.seatId = seatId;
    }

    public Shifts getShiftId() {
        return shiftId;
    }

    public void setShiftId(Shifts shiftId) {
        this.shiftId = shiftId;
    }

}
