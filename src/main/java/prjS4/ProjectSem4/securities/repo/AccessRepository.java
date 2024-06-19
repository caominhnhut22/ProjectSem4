package prjS4.ProjectSem4.securities.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import prjS4.ProjectSem4.entities.Access;
import prjS4.ProjectSem4.entities.Accounts;
import prjS4.ProjectSem4.entities.Roles;

public interface AccessRepository extends JpaRepository<Access, String> {
    
    List<Access> findByAccId(Accounts account);

    List<Access> findByRoleId(Roles role);
    
}
