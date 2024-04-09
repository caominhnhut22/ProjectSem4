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
@Table(name = "Cinemas")
@NamedQueries({
    @NamedQuery(name = "Cinemas.findAll", query = "SELECT c FROM Cinemas c"),
    @NamedQuery(name = "Cinemas.findByCinemaId", query = "SELECT c FROM Cinemas c WHERE c.cinemaId = :cinemaId"),
    @NamedQuery(name = "Cinemas.findByCinemaName", query = "SELECT c FROM Cinemas c WHERE c.cinemaName = :cinemaName"),
    @NamedQuery(name = "Cinemas.findByCinemaStatus", query = "SELECT c FROM Cinemas c WHERE c.cinemaStatus = :cinemaStatus")})
public class Cinemas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cinema_id")
    private String cinemaId;
    @Column(name = "cinema_name")
    private String cinemaName;
    @Column(name = "cinema_status")
    private Integer cinemaStatus;
    @JoinColumn(name = "ctype_id", referencedColumnName = "ctype_id")
    @ManyToOne
    private CinemaType ctypeId;
    @JoinColumn(name = "theater_id", referencedColumnName = "theater_id")
    @ManyToOne
    private Theaters theaterId;
    @OneToMany(mappedBy = "cinemaId")
    private List<Seats> seatsList;
    @OneToMany(mappedBy = "cinemaId")
    private List<Shifts> shiftsList;

    public Cinemas() {
    }

    public Cinemas(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public Integer getCinemaStatus() {
        return cinemaStatus;
    }

    public void setCinemaStatus(Integer cinemaStatus) {
        this.cinemaStatus = cinemaStatus;
    }

    public CinemaType getCtypeId() {
        return ctypeId;
    }

    public void setCtypeId(CinemaType ctypeId) {
        this.ctypeId = ctypeId;
    }

    public Theaters getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Theaters theaterId) {
        this.theaterId = theaterId;
    }

    public List<Seats> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<Seats> seatsList) {
        this.seatsList = seatsList;
    }

    public List<Shifts> getShiftsList() {
        return shiftsList;
    }

    public void setShiftsList(List<Shifts> shiftsList) {
        this.shiftsList = shiftsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cinemaId != null ? cinemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cinemas)) {
            return false;
        }
        Cinemas other = (Cinemas) object;
        if ((this.cinemaId == null && other.cinemaId != null) || (this.cinemaId != null && !this.cinemaId.equals(other.cinemaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prjS4.ProjectSem4.entities.Cinemas[ cinemaId=" + cinemaId + " ]";
    }
    
}
