package prjS4.ProjectSem4.interfaces;

import java.util.List;
import prjS4.ProjectSem4.entities.Films;

public interface IFilmService {
    
    List<Films> getAllFilms();
        
    Films getFilmById(String filmId);
    
    Films createFilm(Films film);
    
    Films updateFilm(String filmId, Films film);
    
    void deleteFilm(String filmId);
    
    List<Films> getFilmsByCategory(String categoryId);
    
    List<Films> getFilmsByDirector(String directorName);
    
    List<Films> getFilmsByActor(String actorName);
    
}
