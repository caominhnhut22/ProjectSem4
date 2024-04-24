package prjS4.ProjectSem4.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Theaters;
import prjS4.ProjectSem4.interfaces.ITheaterService;
import prjS4.ProjectSem4.repositories.TheaterRepository;

@Service
public class TheaterService implements ITheaterService {
    
    @Autowired
    private TheaterRepository tr;

    @Override
    public List<Theaters> findAll() {
        try {
            return tr.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve theaters.", e);
        }
    }

    @Override
    public Theaters findOne(String id) {
        try {
            return tr.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find theater with id: " + id, e);
        }
    }

    @Override
    public void saveTheater(Theaters theater) {
        try {
            tr.save(theater);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save theater.", e);
        }
    }

    @Override
    public void changeStatusTheater(String id) {
        try {
            tr.changeStatus(id, Integer.MAX_VALUE);
        } catch (Exception e) {
            throw new RuntimeException("Failed to change status for theater with id: " + id, e);
        }
    }
    
}
