/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author VOCAO
 */
@Entity
@Table(name = "Seats")
@NamedQueries({
    @NamedQuery(name = "Seats.findAll", query = "SELECT s FROM Seats s"),
    @NamedQuery(name = "Seats.findBySeatId", query = "SELECT s FROM Seats s WHERE s.seatId = :seatId"),
    @NamedQuery(name = "Seats.findBySeatRow", query = "SELECT s FROM Seats s WHERE s.seatRow = :seatRow"),
    @NamedQuery(name = "Seats.findBySeatColumn", query = "SELECT s FROM Seats s WHERE s.seatColumn = :seatColumn"),
    @NamedQuery(name = "Seats.findBySeatStatus", query = "SELECT s FROM Seats s WHERE s.seatStatus = :seatStatus")})
public class Seats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "seat_id")
    private String seatId;
    @Column(name = "seat_row")
    private Integer seatRow;
    @Column(name = "seat_column")
    private Integer seatColumn;
    @Column(name = "seat_status")
    private Integer seatStatus;
    @JoinColumn(name = "cinema_id", referencedColumnName = "cinema_id")
    @ManyToOne
    private Cinemas cinemaId;
    @JoinColumn(name = "stype_id", referencedColumnName = "stype_id")
    @ManyToOne
    private SeatType stypeId;
    @OneToMany(mappedBy = "seatId")
    private List<Tickets> ticketsList;

    public Seats() {
    }

    public Seats(String seatId) {
        this.seatId = seatId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public Integer getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Integer seatRow) {
        this.seatRow = seatRow;
    }

    public Integer getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(Integer seatColumn) {
        this.seatColumn = seatColumn;
    }

    public Integer getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(Integer seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Cinemas getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Cinemas cinemaId) {
        this.cinemaId = cinemaId;
    }

    public SeatType getStypeId() {
        return stypeId;
    }

    public void setStypeId(SeatType stypeId) {
        this.stypeId = stypeId;
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
        hash += (seatId != null ? seatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seats)) {
            return false;
        }
        Seats other = (Seats) object;
        if ((this.seatId == null && other.seatId != null) || (this.seatId != null && !this.seatId.equals(other.seatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prjS4.ProjectSem4.entities.Seats[ seatId=" + seatId + " ]";
    }
    
}
