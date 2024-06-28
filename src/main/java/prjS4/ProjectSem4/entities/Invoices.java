package prjS4.ProjectSem4.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Invoices")
@NamedQueries({
    @NamedQuery(name = "Invoices.findAll", query = "SELECT i FROM Invoices i"),
    @NamedQuery(name = "Invoices.findByInvId", query = "SELECT i FROM Invoices i WHERE i.invId = :invId"),
    @NamedQuery(name = "Invoices.findByInvDate", query = "SELECT i FROM Invoices i WHERE i.invDate = :invDate"),
    @NamedQuery(name = "Invoices.findByInvTotal", query = "SELECT i FROM Invoices i WHERE i.invTotal = :invTotal"),
    @NamedQuery(name = "Invoices.findByInvStatus", query = "SELECT i FROM Invoices i WHERE i.invStatus = :invStatus")})
public class Invoices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "inv_id")
    private String invId;
    @Column(name = "inv_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inv_total")
    private BigDecimal invTotal;
    @Column(name = "inv_status")
    private Integer invStatus;
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Accounts accId;
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tickets ticketId;

    public Invoices() {
        this.invId = UUID.randomUUID().toString();
    }

    public Invoices(String invId) {
        this.invId = invId;
    }

    public String getInvId() {
        return invId;
    }

    public void setInvId(String invId) {
        this.invId = invId;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public BigDecimal getInvTotal() {
        return invTotal;
    }

    public void setInvTotal(BigDecimal invTotal) {
        this.invTotal = invTotal;
    }

    public Integer getInvStatus() {
        return invStatus;
    }

    public void setInvStatus(Integer invStatus) {
        this.invStatus = invStatus;
    }

    public Accounts getAccId() {
        return accId;
    }

    public void setAccId(Accounts accId) {
        this.accId = accId;
    }

    public Tickets getTicketId() {
        return ticketId;
    }

    public void setTicketId(Tickets ticketId) {
        this.ticketId = ticketId;
    }
    
}
