package prjS4.ProjectSem4.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Shifts;
import prjS4.ProjectSem4.interfaces.IShiftService;
import prjS4.ProjectSem4.repositories.ShiftRepository;

@Service
public class ShiftService implements IShiftService {

    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public List<Shifts> getAllShifts() {
        return shiftRepository.findAll();
    }

    @Override
    public Shifts getShiftById(String id) {
        return shiftRepository.findById(id).orElse(null);
    }

    @Override
    public Shifts createShift(Shifts shift) {
        return shiftRepository.save(shift);
    }

    @Override
    public Shifts updateShift(String id, Shifts shift) {
        if (!shiftRepository.existsById(id)) {
            return null;
        }
        shift.setShiftId(id);
        return shiftRepository.save(shift);
    }

    @Override
    public void deleteShift(String id) {
        shiftRepository.deleteById(id);
    }
    
}
