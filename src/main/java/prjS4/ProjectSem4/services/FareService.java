package prjS4.ProjectSem4.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Fares;
import prjS4.ProjectSem4.interfaces.IFareService;
import prjS4.ProjectSem4.repositories.FareRepository;

@Service
public class FareService implements IFareService {

    @Autowired
    private FareRepository fareRepository;

    @Override
    public List<Fares> getAllFares() {
        return fareRepository.findAll();
    }

    @Override
    public Fares getFareById(String id) {
        return fareRepository.findById(id).orElse(null);
    }

    @Override
    public Fares createFare(Fares fare) {
        return fareRepository.save(fare);
    }

    @Override
    public Fares updateFare(String id, Fares fare) {
        if (!fareRepository.existsById(id)) {
            return null;
        }
        fare.setFareId(id);
        return fareRepository.save(fare);
    }

    @Override
    public void deleteFare(String id) {
        fareRepository.deleteById(id);
    }
    
}
