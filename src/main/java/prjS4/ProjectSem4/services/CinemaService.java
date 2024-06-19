package prjS4.ProjectSem4.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Cinemas;
import prjS4.ProjectSem4.interfaces.ICinemaService;
import prjS4.ProjectSem4.repositories.CinemaRepository;

@Service
public class CinemaService implements ICinemaService {
    
    @Autowired
    private CinemaRepository cinemaRepository;

   @Override
    public List<Cinemas> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinemas getCinemaById(String id) {
        Cinemas cinema = cinemaRepository.findById(id).orElse(null);
        return cinema;
    }

    @Override
    public Cinemas createCinema(Cinemas cinema) {
        return cinemaRepository.save(cinema);
    }
    
    
    @Override
    public Cinemas updateCinema(String id, Cinemas cinemaDetails) {
        Cinemas existingCinema = cinemaRepository.findById(id).orElse(null);
        if (existingCinema != null) {
            existingCinema.setCinemaName(cinemaDetails.getCinemaName());
            existingCinema.setCinemaStatus(cinemaDetails.getCinemaStatus());
            
            return cinemaRepository.save(existingCinema);
        }
        return null; 
    }

    @Override
    public boolean deleteCinema(String id) {
        if (cinemaRepository.existsById(id)) {
            cinemaRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
