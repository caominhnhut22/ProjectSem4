package prjS4.ProjectSem4.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import prjS4.ProjectSem4.entities.Cinemas;
import prjS4.ProjectSem4.interfaces.ICinemaService;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaAPI {

    @Autowired
    private ICinemaService cinemaService;

    @GetMapping
    public ResponseEntity<List<Cinemas>> getAllCinemas() {
        List<Cinemas> cinemas = cinemaService.getAllCinemas();
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinemas> getCinemaById(@PathVariable String id) {
        Cinemas cinema = cinemaService.getCinemaById(id);
        if (cinema != null) {
            return new ResponseEntity<>(cinema, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Cinemas> createCinema(@RequestBody Cinemas cinema) {
        Cinemas createdCinema = cinemaService.createCinema(cinema);
        return new ResponseEntity<>(createdCinema, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Cinemas> updateCinema(@PathVariable String id, @RequestBody Cinemas cinemaDetails) {
        Cinemas updatedCinema = cinemaService.updateCinema(id, cinemaDetails);
        if (updatedCinema != null) {
            return new ResponseEntity<>(updatedCinema, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCinema(@PathVariable String id) {
        boolean isDeleted = cinemaService.deleteCinema(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
