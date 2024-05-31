package prjS4.ProjectSem4.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Categories")
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c"),
    @NamedQuery(name = "Categories.findByCateId", query = "SELECT c FROM Categories c WHERE c.cateId = :cateId"),
    @NamedQuery(name = "Categories.findByCateName", query = "SELECT c FROM Categories c WHERE c.cateName = :cateName"),
    @NamedQuery(name = "Categories.findByCateStatus", query = "SELECT c FROM Categories c WHERE c.cateStatus = :cateStatus")})
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cate_id")
    private String cateId;
    @Column(name = "cate_name")
    private String cateName;
    @Column(name = "cate_status")
    private Integer cateStatus;
    @JoinTable(name = "FilmCategory", joinColumns = {
        @JoinColumn(name = "cate_id", referencedColumnName = "cate_id")}, inverseJoinColumns = {
        @JoinColumn(name = "film_id", referencedColumnName = "film_id")})
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Films> filmsList;

    public Categories() {
        this.cateId = UUID.randomUUID().toString();
    }

    public Categories(String cateId) {
        this.cateId = cateId;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getCateStatus() {
        return cateStatus;
    }

    public void setCateStatus(Integer cateStatus) {
        this.cateStatus = cateStatus;
    }

    public List<Films> getFilmsList() {
        return filmsList;
    }

    public void setFilmsList(List<Films> filmsList) {
        this.filmsList = filmsList;
    }

}
