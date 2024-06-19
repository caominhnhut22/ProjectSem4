package prjS4.ProjectSem4.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import prjS4.ProjectSem4.entities.Films;

public interface FilmRepository extends JpaRepository<Films, String> {
    
    List<Films> findByCategoryId(String categoryId);
  
    List<Films> findByDirectorName(String directorName);
    
    List<Films> findByActorName(String actorName);
    
}
