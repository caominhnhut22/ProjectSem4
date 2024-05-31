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
import java.util.UUID;

@Entity
@Table(name = "CinemaType")
@NamedQueries({
    @NamedQuery(name = "CinemaType.findAll", query = "SELECT c FROM CinemaType c"),
    @NamedQuery(name = "CinemaType.findByCtypeId", query = "SELECT c FROM CinemaType c WHERE c.ctypeId = :ctypeId"),
    @NamedQuery(name = "CinemaType.findByCtypeName", query = "SELECT c FROM CinemaType c WHERE c.ctypeName = :ctypeName"),
    @NamedQuery(name = "CinemaType.findByCtypeStatus", query = "SELECT c FROM CinemaType c WHERE c.ctypeStatus = :ctypeStatus")})
public class CinemaType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ctype_id")
    private String ctypeId;
    @Column(name = "ctype_name")
    private String ctypeName;
    @Column(name = "ctype_status")
    private Integer ctypeStatus;
    @OneToMany(mappedBy = "ctypeId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Cinemas> cinemasList;

    public CinemaType() {
        this.ctypeId = UUID.randomUUID().toString();
    }

    public CinemaType(String ctypeId) {
        this.ctypeId = ctypeId;
    }

    public String getCtypeId() {
        return ctypeId;
    }

    public void setCtypeId(String ctypeId) {
        this.ctypeId = ctypeId;
    }

    public String getCtypeName() {
        return ctypeName;
    }

    public void setCtypeName(String ctypeName) {
        this.ctypeName = ctypeName;
    }

    public Integer getCtypeStatus() {
        return ctypeStatus;
    }

    public void setCtypeStatus(Integer ctypeStatus) {
        this.ctypeStatus = ctypeStatus;
    }

    public List<Cinemas> getCinemasList() {
        return cinemasList;
    }

    public void setCinemasList(List<Cinemas> cinemasList) {
        this.cinemasList = cinemasList;
    }
    
}
