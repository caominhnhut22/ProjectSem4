package prjS4.ProjectSem4.interfaces;

import java.util.List;
import prjS4.ProjectSem4.entities.Roles;

public interface IRoleService {
    
    List<Roles> getAllRoles();
    
    Roles getRoleById(String id);
    
    Roles createRole(Roles role);
    
    Roles updateRole(String id, Roles role);
    
    boolean deleteRole(String id);
    
}
