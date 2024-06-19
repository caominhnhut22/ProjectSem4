package prjS4.ProjectSem4.securities.service;

import prjS4.ProjectSem4.entities.Access;

import java.util.List;
import java.util.Optional;
import prjS4.ProjectSem4.entities.Accounts;
import prjS4.ProjectSem4.entities.Roles;

public interface IAccessService {
    
    List<Access> findAll();
    
    Optional<Access> findById(String id);
    
    Access save(Access access);
    
    void deleteById(String id);
    
    List<Access> findByAccount(Accounts account);
            
    List<Access> findByRole(Roles role);
    
}