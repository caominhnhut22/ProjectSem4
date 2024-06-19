package prjS4.ProjectSem4.interfaces;

import java.util.List;
import prjS4.ProjectSem4.entities.Cinemas;

public interface ICinemaService {
    
    List<Cinemas> getAllCinemas();

    Cinemas getCinemaById(String id);

    Cinemas createCinema(Cinemas cinema);

    Cinemas updateCinema(String id, Cinemas cinemaDetails);

    boolean deleteCinema(String id);
    
}
