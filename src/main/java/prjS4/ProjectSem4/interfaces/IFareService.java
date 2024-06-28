package prjS4.ProjectSem4.interfaces;

import java.util.List;
import prjS4.ProjectSem4.entities.Fares;

public interface IFareService {
    
    List<Fares> getAllFares();
    
    Fares getFareById(String id);
    
    Fares createFare(Fares fare);
    
    Fares updateFare(String id, Fares fare);
    
    void deleteFare(String id);
    
}
