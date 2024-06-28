package prjS4.ProjectSem4.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import prjS4.ProjectSem4.entities.Films;

public interface FilmRepository extends JpaRepository<Films, String> {
    
    @Query("SELECT f FROM Films f JOIN f.categories c WHERE c.cateId = :categoryId")
    List<Films> findByCategoryId(String categoryId);
  
    List<Films> findByFilmDirector(String filmDirector);
    
    List<Films> findByFilmActors(String filmActors);
    
}
