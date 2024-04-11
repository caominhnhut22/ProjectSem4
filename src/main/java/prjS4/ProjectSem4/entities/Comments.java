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

}
