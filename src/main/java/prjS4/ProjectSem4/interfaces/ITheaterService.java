package prjS4.ProjectSem4.interfaces;

import java.util.List;
import prjS4.ProjectSem4.entities.Theaters;

public interface ITheaterService {
    
    List<Theaters> findAll();
    
    Theaters findOne(String id);
    
    void saveTheater(Theaters theater);
    
    void changeStatusTheater(String id);
    
}
