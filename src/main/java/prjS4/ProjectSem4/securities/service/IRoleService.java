package prjS4.ProjectSem4.securities.service;

import prjS4.ProjectSem4.entities.Roles;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    
    List<Roles> findAll();
    
    Optional<Roles> findById(String id);
    
    Roles save(Roles role);
    
    void deleteById(String id);
    
    Roles findByRoleNum(Integer roleNum);
    
}