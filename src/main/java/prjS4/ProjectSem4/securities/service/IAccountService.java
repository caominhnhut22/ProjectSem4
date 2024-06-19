package prjS4.ProjectSem4.securities.service;

import prjS4.ProjectSem4.entities.Accounts;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    
    List<Accounts> findAll();
    
    Optional<Accounts> findById(String id);
    
    Accounts findByEmail(String email);
    
    Accounts findByUserName(String userName);
    
    Accounts save(Accounts account);
    
    void deleteById(String id);
    
}