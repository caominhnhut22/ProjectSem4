package prjS4.ProjectSem4.dto;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

public class FilmDTO {
    
    private String filmId;
    
    private String filmName;
    
    private String filmContent;

    private Integer filmDuration;

    private MultipartFile filmPoster;

    private String filmLanguage;

    private String filmDirector;
    
    private String filmActors;
    
    private String filmTrailer;

    private Date filmFrom;

    private Date filmTo;
    
    private Integer filmRating;
    
    private Integer ageLimit;
    
    private Integer filmStatus;

    public FilmDTO () {}

    public FilmDTO(String filmId, String filmName, String filmContent, Integer filmDuration, MultipartFile filmPoster, String filmLanguage, String filmDirector, String filmActors, String filmTrailer, Date filmFrom, Date filmTo, Integer filmRating, Integer ageLimit, Integer filmStatus) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmContent = filmContent;
        this.filmDuration = filmDuration;
        this.filmPoster = filmPoster;
        this.filmLanguage = filmLanguage;
        this.filmDirector = filmDirector;
        this.filmActors = filmActors;
        this.filmTrailer = filmTrailer;
        this.filmFrom = filmFrom;
        this.filmTo = filmTo;
        this.filmRating = filmRating;
        this.ageLimit = ageLimit;
        this.filmStatus = filmStatus;
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

    public MultipartFile getFilmPoster() {
        return filmPoster;
    }

    public void setFilmPoster(MultipartFile filmPoster) {
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

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Integer getFilmStatus() {
        return filmStatus;
    }

    public void setFilmStatus(Integer filmStatus) {
        this.filmStatus = filmStatus;
    }
    
    
    
}
