package prjS4.ProjectSem4.interfaces;

import java.util.List;
import prjS4.ProjectSem4.entities.Shifts;

public interface IShiftService {
    
    List<Shifts> getAllShifts();
    
    Shifts getShiftById(String id);
    
    Shifts createShift(Shifts shift);
    
    Shifts updateShift(String id, Shifts shift);
    
    void deleteShift(String id);
    
}
