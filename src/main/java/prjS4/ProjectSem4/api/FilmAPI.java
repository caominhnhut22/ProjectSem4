package prjS4.ProjectSem4.api;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import prjS4.ProjectSem4.dto.FilmDTO;
import prjS4.ProjectSem4.entities.Films;
import prjS4.ProjectSem4.interfaces.IFilmService;

@RestController
@RequestMapping("/api/films")
public class FilmAPI {

    @Autowired
    private IFilmService filmService;
    
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping()
    public List<Films> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/{id}")
    public Films getFilmById(@PathVariable String id) {
        return filmService.getFilmById(id);
    }

    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Films> createFilm(@ModelAttribute FilmDTO filmDTO) {
        try {
            String fileName = null;
            if (filmDTO.getFilmPoster() != null && filmDTO.getFilmPoster().getCount() > 0) {
                fileName = saveFile((MultipartFile) filmDTO.getFilmPoster());
            }
            
            Films film = new Films();
            film.setFilmId(UUID.randomUUID().toString());
            film.setFilmName(filmDTO.getFilmName());
            film.setFilmContent(filmDTO.getFilmContent());
            film.setFilmDuration(filmDTO.getFilmDuration());
            film.setFilmPoster(fileName);
            film.setFilmLanguage(filmDTO.getFilmLanguage());
            film.setFilmDirector(filmDTO.getFilmDirector());
            film.setFilmActors(filmDTO.getFilmActors());
            film.setFilmTrailer(filmDTO.getFilmTrailer());
            film.setFilmFrom(filmDTO.getFilmFrom());
            film.setFilmTo(filmDTO.getFilmTo());
            film.setFilmRating(filmDTO.getFilmRating());
            film.setAgeLimit(filmDTO.getAgeLimit());
            film.setFilmStatus(filmDTO.getFilmStatus());

            Films savedFilm = filmService.createFilm(film);
            return new ResponseEntity<>(savedFilm, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Films> updateFilm(@PathVariable String id, @ModelAttribute FilmDTO filmDTO) {
        try {
            Films film = filmService.getFilmById(id);
            if (film == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            if (filmDTO.getFilmPoster() != null && filmDTO.getFilmPoster().getCount() > 0) {
                String fileName = saveFile((MultipartFile) filmDTO.getFilmPoster());
                film.setFilmPoster(fileName);
            }
            film.setFilmName(filmDTO.getFilmName());
            film.setFilmContent(filmDTO.getFilmContent());
            film.setFilmDuration(filmDTO.getFilmDuration());
            film.setFilmLanguage(filmDTO.getFilmLanguage());
            film.setFilmDirector(filmDTO.getFilmDirector());
            film.setFilmActors(filmDTO.getFilmActors());
            film.setFilmTrailer(filmDTO.getFilmTrailer());
            film.setFilmFrom(filmDTO.getFilmFrom());
            film.setFilmTo(filmDTO.getFilmTo());
            film.setFilmRating(filmDTO.getFilmRating());
            film.setAgeLimit(filmDTO.getAgeLimit());
            film.setFilmStatus(filmDTO.getFilmStatus());

            Films updatedFilm = filmService.updateFilm(id, film);
            return new ResponseEntity<>(updatedFilm, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteFilm(@PathVariable String id) {
        try {
            filmService.deleteFilm(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/category/{categoryId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Films>> getFilmsByCategory(@PathVariable String categoryId) {
        List<Films> films = filmService.getFilmsByCategory(categoryId);
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/director/{directorName}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Films>> getFilmsByDirector(@PathVariable String directorName) {
        List<Films> films = filmService.getFilmsByDirector(directorName);
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/actor/{actorName}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Films>> getFilmsByActor(@PathVariable String actorName) {
        List<Films> films = filmService.getFilmsByActor(actorName);
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @GetMapping("/poster/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFilmPoster(@PathVariable String filename) {
        try {
            Path filePath = Paths.get(uploadPath).resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG) // or MediaType.IMAGE_PNG based on your file type
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    
    private String saveFile(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("File is empty");
        }
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path targetLocation = Paths.get(uploadPath).resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }
    
}