package prjS4.ProjectSem4.securities.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import prjS4.ProjectSem4.entities.Roles;

public interface RoleRepository extends JpaRepository<Roles, String> {
    
    Roles findByRoleNum(Integer roleNum);
    
}
