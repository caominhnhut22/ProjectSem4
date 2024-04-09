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
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author VOCAO
 */
@Entity
@Table(name = "Access")
@NamedQueries({
    @NamedQuery(name = "Access.findAll", query = "SELECT a FROM Access a"),
    @NamedQuery(name = "Access.findByAcsId", query = "SELECT a FROM Access a WHERE a.acsId = :acsId")})
public class Access implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "acs_id")
    private String acsId;
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
    @ManyToOne
    private Accounts accId;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne
    private Roles roleId;

    public Access() {
    }

    public Access(String acsId) {
        this.acsId = acsId;
    }

    public String getAcsId() {
        return acsId;
    }

    public void setAcsId(String acsId) {
        this.acsId = acsId;
    }

    public Accounts getAccId() {
        return accId;
    }

    public void setAccId(Accounts accId) {
        this.accId = accId;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acsId != null ? acsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Access)) {
            return false;
        }
        Access other = (Access) object;
        if ((this.acsId == null && other.acsId != null) || (this.acsId != null && !this.acsId.equals(other.acsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prjS4.ProjectSem4.entities.Access[ acsId=" + acsId + " ]";
    }
    
}
