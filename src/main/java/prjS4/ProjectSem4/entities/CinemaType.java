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
import java.util.List;

/**
 *
 * @author VOCAO
 */
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
    @OneToMany(mappedBy = "ctypeId")
    private List<Cinemas> cinemasList;

    public CinemaType() {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctypeId != null ? ctypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CinemaType)) {
            return false;
        }
        CinemaType other = (CinemaType) object;
        if ((this.ctypeId == null && other.ctypeId != null) || (this.ctypeId != null && !this.ctypeId.equals(other.ctypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prjS4.ProjectSem4.entities.CinemaType[ ctypeId=" + ctypeId + " ]";
    }
    
}
