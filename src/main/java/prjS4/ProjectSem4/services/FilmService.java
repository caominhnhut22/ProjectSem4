package prjS4.ProjectSem4.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Films;
import prjS4.ProjectSem4.interfaces.IFilmService;
import prjS4.ProjectSem4.repositories.FilmRepository;

@Service
public class FilmService implements IFilmService {
    
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Films> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Films getFilmById(String filmId) {
        return filmRepository.findById(filmId).orElse(null);
    }

    @Override
    public Films createFilm(Films film) {
        return filmRepository.save(film);
    }

    @Override
    public Films updateFilm(String filmId, Films film) {
        if (!filmRepository.existsById(filmId)) {
            return null;
        }
        film.setFilmId(filmId);
        return filmRepository.save(film);
    }

    @Override
    public void deleteFilm(String filmId) {
        filmRepository.deleteById(filmId);
    }

    @Override
    public List<Films> getFilmsByCategory(String categoryId) {
        return filmRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Films> getFilmsByDirector(String directorName) {
        return filmRepository.findByDirectorName(directorName);
    }

    @Override
    public List<Films> getFilmsByActor(String actorName) {
        return filmRepository.findByActorName(actorName);
    }
    
}
