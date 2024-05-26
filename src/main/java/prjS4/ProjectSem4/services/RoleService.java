package prjS4.ProjectSem4.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Roles;
import prjS4.ProjectSem4.interfaces.IRoleService;
import prjS4.ProjectSem4.repositories.RoleRepository;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Roles getRoleById(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Roles createRole(Roles role) {
        return roleRepository.save(role);
    }

    @Override
    public Roles updateRole(String id, Roles roleDetails) {
        return roleRepository.findById(id).map(role -> {
            role.setRoleNum(roleDetails.getRoleNum());
            return roleRepository.save(role);
        }).orElse(null);
    }

    @Override
    public boolean deleteRole(String id) {
        return roleRepository.findById(id).map(role -> {
            roleRepository.delete(role);
            return true;
        }).orElse(false);
    }
    
}
