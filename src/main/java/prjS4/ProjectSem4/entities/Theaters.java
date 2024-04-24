package prjS4.ProjectSem4.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Theaters")
@NamedQueries({
    @NamedQuery(name = "Theaters.findAll", query = "SELECT t FROM Theaters t"),
    @NamedQuery(name = "Theaters.findByTheaterId", query = "SELECT t FROM Theaters t WHERE t.theaterId = :theaterId"),
    @NamedQuery(name = "Theaters.findByTheaterName", query = "SELECT t FROM Theaters t WHERE t.theaterName = :theaterName"),
    @NamedQuery(name = "Theaters.findByTheaterAddress", query = "SELECT t FROM Theaters t WHERE t.theaterAddress = :theaterAddress"),
    @NamedQuery(name = "Theaters.findByTheaterStatus", query = "SELECT t FROM Theaters t WHERE t.theaterStatus = :theaterStatus")})
public class Theaters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "theater_id")
    private String theaterId;
    @Column(name = "theater_name")
    private String theaterName;
    @Column(name = "theater_address")
    private String theaterAddress;
    @Column(name = "theater_status")
    private Integer theaterStatus;
    @OneToMany(mappedBy = "theaterId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Cinemas> cinemasList;

    public Theaters() {
    }

    public Theaters(String theaterId, String theaterName, String theaterAddress, Integer theaterStatus, List<Cinemas> cinemasList) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.theaterAddress = theaterAddress;
        this.theaterStatus = theaterStatus;
        this.cinemasList = cinemasList;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterAddress() {
        return theaterAddress;
    }

    public void setTheaterAddress(String theaterAddress) {
        this.theaterAddress = theaterAddress;
    }

    public Integer getTheaterStatus() {
        return theaterStatus;
    }

    public void setTheaterStatus(Integer theaterStatus) {
        this.theaterStatus = theaterStatus;
    }

    public List<Cinemas> getCinemasList() {
        return cinemasList;
    }

    public void setCinemasList(List<Cinemas> cinemasList) {
        this.cinemasList = cinemasList;
    }

}
