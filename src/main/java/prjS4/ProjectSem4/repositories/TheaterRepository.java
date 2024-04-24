package prjS4.ProjectSem4.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import prjS4.ProjectSem4.entities.Theaters;

public interface TheaterRepository extends JpaRepository<Theaters, String> {
    
    @Modifying
    @Transactional
    @Query("UPDATE Theaters t SET t.theaterStatus = :theaterStatus WHERE t.theaterId = :theaterId")
    void changeStatus(@Param("theaterId") String theaterId, @Param("theaterStatus") Integer theaterStatus); 
    
}
