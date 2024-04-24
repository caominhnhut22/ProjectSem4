package prjS4.ProjectSem4.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import prjS4.ProjectSem4.entities.Theaters;
import prjS4.ProjectSem4.interfaces.ITheaterService;

@RestController
@RequestMapping("/api/theaters")
public class TheaterAPI {
    
    @Autowired
    private ITheaterService its;
    
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Theaters> get() {
        try {
            return its.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve theaters.", e);
        }
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Theaters get(@PathVariable("id") String id) {
        try {
            return its.findOne(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve theater with id: " + id, e);
        }
    }
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody Theaters newTheaters) {
        try {
            its.saveTheater(newTheaters);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save theater.", e);
        }
    } 
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void put(@PathVariable("id") String id, @RequestBody Theaters editTheaters) {
        try {
            its.saveTheater(editTheaters);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update theater with id: " + id, e);
        }
    } 
    
    @PutMapping("/{id}/status")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void changeStatus(@PathVariable("id") String id) {
        try {
            its.changeStatusTheater(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to change status for theater with id: " + id, e);
        }
    }
    
}
