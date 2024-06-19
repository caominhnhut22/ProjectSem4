package prjS4.ProjectSem4.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import prjS4.ProjectSem4.entities.Films;
import prjS4.ProjectSem4.interfaces.IFilmService;

@RestController
@RequestMapping("/api/films")
public class FilmAPI {

    @Autowired
    private IFilmService filmService;

    @GetMapping
    public List<Films> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public Films getFilmById(@PathVariable String id) {
        return filmService.getFilmById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Films createFilm(@RequestBody Films film) {
        return filmService.createFilm(film);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Films updateFilm(@PathVariable String id, @RequestBody Films film) {
        return filmService.updateFilm(id, film);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteFilm(@PathVariable String id) {
        filmService.deleteFilm(id);
    }

    @GetMapping("/category/{categoryId}")
    @PreAuthorize("hasRole('USER')")
    public List<Films> getFilmsByCategory(@PathVariable String categoryId) {
        return filmService.getFilmsByCategory(categoryId);
    }

    @GetMapping("/director/{directorName}")
    @PreAuthorize("hasRole('USER')")
    public List<Films> getFilmsByDirector(@PathVariable String directorName) {
        return filmService.getFilmsByDirector(directorName);
    }

    @GetMapping("/actor/{actorName}")
    @PreAuthorize("hasRole('USER')")
    public List<Films> getFilmsByActor(@PathVariable String actorName) {
        return filmService.getFilmsByActor(actorName);
    }
}