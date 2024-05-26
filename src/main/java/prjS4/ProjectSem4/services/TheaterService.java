package prjS4.ProjectSem4.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Theaters;
import prjS4.ProjectSem4.interfaces.ITheaterService;
import prjS4.ProjectSem4.repositories.TheaterRepository;
//import prjS4.ProjectSem4.validations.TheaterValidator;

@Service
public class TheaterService implements ITheaterService {
    
//    @Autowired
//    private TheaterRepository tr;
//    
//    @Autowired
//    private TheaterValidator tv;
//
//    @Override
//    public List<Theaters> findAll() {
//        try {
//            return tr.findAll();
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to retrieve theaters.", e);
//        }
//    }
//
//    @Override
//    public Theaters findOne(String id) {
//        try {
//            return tr.findById(id).orElse(null);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to find theater with id: " + id, e);
//        }
//    }
//
//    @Override
//    public void saveTheater(Theaters theater) {
//        List<String> errors = tv.validate(theater);
//        if (!errors.isEmpty()) {
//            throw new IllegalArgumentException("Theater validation failed: " + String.join(", ", errors));
//        } else {
//            try {
//                tr.save(theater);
//            } catch (Exception e) {
//                throw new RuntimeException("Failed to save theater.", e);
//            }
//        }
//    }
//
//    @Override
//    public void changeStatusTheater(String id) {
//        Theaters theater = tr.findById(id).orElse(null);
//        if (theater == null) {
//            throw new IllegalArgumentException("Theater with id " + id + " does not exist.");
//        }
//
//        List<String> errors = tv.validate(theater);
//        if (!errors.isEmpty()) {
//            throw new IllegalArgumentException("Theater validation failed: " + String.join(", ", errors));
//        }
//
//        try {
//            tr.changeStatus(id, Integer.MAX_VALUE);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to change status for theater with id: " + id, e);
//        }
//    }
//    
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
