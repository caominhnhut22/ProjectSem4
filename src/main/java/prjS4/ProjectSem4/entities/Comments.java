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
@Table(name = "Comments")
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
    @NamedQuery(name = "Comments.findByCmtId", query = "SELECT c FROM Comments c WHERE c.cmtId = :cmtId"),
    @NamedQuery(name = "Comments.findByCmtContent", query = "SELECT c FROM Comments c WHERE c.cmtContent = :cmtContent"),
    @NamedQuery(name = "Comments.findByCmtStatus", query = "SELECT c FROM Comments c WHERE c.cmtStatus = :cmtStatus")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cmt_id")
    private String cmtId;
    @Column(name = "cmt_content")
    private String cmtContent;
    @Column(name = "cmt_status")
    private Integer cmtStatus;
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
    @ManyToOne
    private Accounts accId;
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    @ManyToOne
    private Films filmId;

    public Comments() {
    }

    public Comments(String cmtId) {
        this.cmtId = cmtId;
    }

    public String getCmtId() {
        return cmtId;
    }

    public void setCmtId(String cmtId) {
        this.cmtId = cmtId;
    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }

    public Integer getCmtStatus() {
        return cmtStatus;
    }

    public void setCmtStatus(Integer cmtStatus) {
        this.cmtStatus = cmtStatus;
    }

    public Accounts getAccId() {
        return accId;
    }

    public void setAccId(Accounts accId) {
        this.accId = accId;
    }

    public Films getFilmId() {
        return filmId;
    }

    public void setFilmId(Films filmId) {
        this.filmId = filmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmtId != null ? cmtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.cmtId == null && other.cmtId != null) || (this.cmtId != null && !this.cmtId.equals(other.cmtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prjS4.ProjectSem4.entities.Comments[ cmtId=" + cmtId + " ]";
    }
    
}
