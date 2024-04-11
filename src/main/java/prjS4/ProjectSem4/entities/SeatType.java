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
import java.util.List;

@Entity
@Table(name = "SeatType")
@NamedQueries({
    @NamedQuery(name = "SeatType.findAll", query = "SELECT s FROM SeatType s"),
    @NamedQuery(name = "SeatType.findByStypeId", query = "SELECT s FROM SeatType s WHERE s.stypeId = :stypeId"),
    @NamedQuery(name = "SeatType.findByStypeName", query = "SELECT s FROM SeatType s WHERE s.stypeName = :stypeName")})
public class SeatType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "stype_id")
    private String stypeId;
    @Column(name = "stype_name")
    private String stypeName;
    @OneToMany(mappedBy = "stypeId")
    private List<Seats> seatsList;

    public SeatType() {
    }

    public SeatType(String stypeId) {
        this.stypeId = stypeId;
    }

    public String getStypeId() {
        return stypeId;
    }

    public void setStypeId(String stypeId) {
        this.stypeId = stypeId;
    }

    public String getStypeName() {
        return stypeName;
    }

    public void setStypeName(String stypeName) {
        this.stypeName = stypeName;
    }

    public List<Seats> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<Seats> seatsList) {
        this.seatsList = seatsList;
    }
    
}
