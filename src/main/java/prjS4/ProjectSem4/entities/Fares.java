/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjS4.ProjectSem4.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author VOCAO
 */
@Entity
@Table(name = "Fares")
@NamedQueries({
    @NamedQuery(name = "Fares.findAll", query = "SELECT f FROM Fares f"),
    @NamedQuery(name = "Fares.findByFareId", query = "SELECT f FROM Fares f WHERE f.fareId = :fareId"),
    @NamedQuery(name = "Fares.findByFarePrice", query = "SELECT f FROM Fares f WHERE f.farePrice = :farePrice"),
    @NamedQuery(name = "Fares.findByFareStatus", query = "SELECT f FROM Fares f WHERE f.fareStatus = :fareStatus")})
public class Fares implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fare_id")
    private String fareId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fare_price")
    private BigDecimal farePrice;
    @Column(name = "fare_status")
    private Integer fareStatus;
    @OneToMany(mappedBy = "fareId")
    private List<Tickets> ticketsList;

    public Fares() {
    }

    public Fares(String fareId) {
        this.fareId = fareId;
    }

    public String getFareId() {
        return fareId;
    }

    public void setFareId(String fareId) {
        this.fareId = fareId;
    }

    public BigDecimal getFarePrice() {
        return farePrice;
    }

    public void setFarePrice(BigDecimal farePrice) {
        this.farePrice = farePrice;
    }

    public Integer getFareStatus() {
        return fareStatus;
    }

    public void setFareStatus(Integer fareStatus) {
        this.fareStatus = fareStatus;
    }

    public List<Tickets> getTicketsList() {
        return ticketsList;
    }

    public void setTicketsList(List<Tickets> ticketsList) {
        this.ticketsList = ticketsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fareId != null ? fareId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fares)) {
            return false;
        }
        Fares other = (Fares) object;
        if ((this.fareId == null && other.fareId != null) || (this.fareId != null && !this.fareId.equals(other.fareId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prjS4.ProjectSem4.entities.Fares[ fareId=" + fareId + " ]";
    }
    
}
