package prjS4.ProjectSem4.securities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Roles;
import prjS4.ProjectSem4.securities.repo.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Roles> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Roles> findById(String id) {
        return roleRepository.findById(id);
    }

    @Override
    public Roles save(Roles role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(String id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Roles findByRoleNum(Integer roleNum) {
        return roleRepository.findByRoleNum(roleNum);
    }
    
}
