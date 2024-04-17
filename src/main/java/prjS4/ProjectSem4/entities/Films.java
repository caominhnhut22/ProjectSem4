package prjS4.ProjectSem4.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Films")
@NamedQueries({
    @NamedQuery(name = "Films.findAll", query = "SELECT f FROM Films f"),
    @NamedQuery(name = "Films.findByFilmId", query = "SELECT f FROM Films f WHERE f.filmId = :filmId"),
    @NamedQuery(name = "Films.findByFilmName", query = "SELECT f FROM Films f WHERE f.filmName = :filmName"),
    @NamedQuery(name = "Films.findByFilmContent", query = "SELECT f FROM Films f WHERE f.filmContent = :filmContent"),
    @NamedQuery(name = "Films.findByFilmDuration", query = "SELECT f FROM Films f WHERE f.filmDuration = :filmDuration"),
    @NamedQuery(name = "Films.findByFilmPoster", query = "SELECT f FROM Films f WHERE f.filmPoster = :filmPoster"),
    @NamedQuery(name = "Films.findByFilmLanguage", query = "SELECT f FROM Films f WHERE f.filmLanguage = :filmLanguage"),
    @NamedQuery(name = "Films.findByFilmDirector", query = "SELECT f FROM Films f WHERE f.filmDirector = :filmDirector"),
    @NamedQuery(name = "Films.findByFilmActors", query = "SELECT f FROM Films f WHERE f.filmActors = :filmActors"),
    @NamedQuery(name = "Films.findByFilmTrailer", query = "SELECT f FROM Films f WHERE f.filmTrailer = :filmTrailer"),
    @NamedQuery(name = "Films.findByFilmFrom", query = "SELECT f FROM Films f WHERE f.filmFrom = :filmFrom"),
    @NamedQuery(name = "Films.findByFilmTo", query = "SELECT f FROM Films f WHERE f.filmTo = :filmTo"),
    @NamedQuery(name = "Films.findByFilmRating", query = "SELECT f FROM Films f WHERE f.filmRating = :filmRating"),
    @NamedQuery(name = "Films.findByFilmageLimit", query = "SELECT f FROM Films f WHERE f.filmageLimit = :filmageLimit"),
    @NamedQuery(name = "Films.findByFilmStatus", query = "SELECT f FROM Films f WHERE f.filmStatus = :filmStatus")})
public class Films implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "film_id")
    private String filmId;
    @Column(name = "film_name")
    private String filmName;
    @Column(name = "film_content")
    private String filmContent;
    @Column(name = "film_duration")
    private Integer filmDuration;
    @Column(name = "film_poster")
    private String filmPoster;
    @Column(name = "film_language")
    private String filmLanguage;
    @Column(name = "film_director")
    private String filmDirector;
    @Column(name = "film_actors")
    private String filmActors;
    @Column(name = "film_trailer")
    private String filmTrailer;
    @Column(name = "film_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date filmFrom;
    @Column(name = "film_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date filmTo;
    @Column(name = "film_rating")
    private Integer filmRating;
    @Column(name = "film_ageLimit")
    private Integer filmageLimit;
    @Column(name = "film_status")
    private Integer filmStatus;
    @ManyToMany(mappedBy = "filmsList")
    private List<Categories> categoriesList;
    @OneToMany(mappedBy = "filmId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Comments> commentsList;
    @OneToMany(mappedBy = "filmId", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Shifts> shiftsList;

    public Films() {
    }

    public Films(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmContent() {
        return filmContent;
    }

    public void setFilmContent(String filmContent) {
        this.filmContent = filmContent;
    }

    public Integer getFilmDuration() {
        return filmDuration;
    }

    public void setFilmDuration(Integer filmDuration) {
        this.filmDuration = filmDuration;
    }

    public String getFilmPoster() {
        return filmPoster;
    }

    public void setFilmPoster(String filmPoster) {
        this.filmPoster = filmPoster;
    }

    public String getFilmLanguage() {
        return filmLanguage;
    }

    public void setFilmLanguage(String filmLanguage) {
        this.filmLanguage = filmLanguage;
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(String filmDirector) {
        this.filmDirector = filmDirector;
    }

    public String getFilmActors() {
        return filmActors;
    }

    public void setFilmActors(String filmActors) {
        this.filmActors = filmActors;
    }

    public String getFilmTrailer() {
        return filmTrailer;
    }

    public void setFilmTrailer(String filmTrailer) {
        this.filmTrailer = filmTrailer;
    }

    public Date getFilmFrom() {
        return filmFrom;
    }

    public void setFilmFrom(Date filmFrom) {
        this.filmFrom = filmFrom;
    }

    public Date getFilmTo() {
        return filmTo;
    }

    public void setFilmTo(Date filmTo) {
        this.filmTo = filmTo;
    }

    public Integer getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(Integer filmRating) {
        this.filmRating = filmRating;
    }

    public Integer getFilmageLimit() {
        return filmageLimit;
    }

    public void setFilmageLimit(Integer filmageLimit) {
        this.filmageLimit = filmageLimit;
    }

    public Integer getFilmStatus() {
        return filmStatus;
    }

    public void setFilmStatus(Integer filmStatus) {
        this.filmStatus = filmStatus;
    }

    public List<Categories> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public List<Shifts> getShiftsList() {
        return shiftsList;
    }

    public void setShiftsList(List<Shifts> shiftsList) {
        this.shiftsList = shiftsList;
    }

}
