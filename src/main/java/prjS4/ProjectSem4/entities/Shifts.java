package prjS4.ProjectSem4.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Shifts")
@NamedQueries({
    @NamedQuery(name = "Shifts.findAll", query = "SELECT s FROM Shifts s"),
    @NamedQuery(name = "Shifts.findByShiftId", query = "SELECT s FROM Shifts s WHERE s.shiftId = :shiftId"),
    @NamedQuery(name = "Shifts.findByShiftDate", query = "SELECT s FROM Shifts s WHERE s.shiftDate = :shiftDate"),
    @NamedQuery(name = "Shifts.findByShiftStart", query = "SELECT s FROM Shifts s WHERE s.shiftStart = :shiftStart"),
    @NamedQuery(name = "Shifts.findByShiftEnd", query = "SELECT s FROM Shifts s WHERE s.shiftEnd = :shiftEnd"),
    @NamedQuery(name = "Shifts.findByShiftStatus", query = "SELECT s FROM Shifts s WHERE s.shiftStatus = :shiftStatus")})
public class Shifts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "shift_id")
    private String shiftId;
    @Column(name = "shift_date")
    @Temporal(TemporalType.DATE)
    private Date shiftDate;
    @Column(name = "shift_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shiftStart;
    @Column(name = "shift_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shiftEnd;
    @Column(name = "shift_status")
    private Integer shiftStatus;
    @OneToMany(mappedBy = "shiftId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Tickets> ticketsList;
    @JoinColumn(name = "cinema_id", referencedColumnName = "cinema_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cinemas cinemaId;
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Films filmId;

    public Shifts() {
        this.shiftId = UUID.randomUUID().toString();
    }

    public Shifts(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }

    public Date getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(Date shiftStart) {
        this.shiftStart = shiftStart;
    }

    public Date getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(Date shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    public Integer getShiftStatus() {
        return shiftStatus;
    }

    public void setShiftStatus(Integer shiftStatus) {
        this.shiftStatus = shiftStatus;
    }

    public List<Tickets> getTicketsList() {
        return ticketsList;
    }

    public void setTicketsList(List<Tickets> ticketsList) {
        this.ticketsList = ticketsList;
    }

    public Cinemas getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Cinemas cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Films getFilmId() {
        return filmId;
    }

    public void setFilmId(Films filmId) {
        this.filmId = filmId;
    }
    
}
