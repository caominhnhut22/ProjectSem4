package prjS4.ProjectSem4.securities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Access;
import prjS4.ProjectSem4.securities.repo.AccessRepository;

import java.util.List;
import java.util.Optional;
import prjS4.ProjectSem4.entities.Accounts;
import prjS4.ProjectSem4.entities.Roles;

@Service
public class AccessService implements IAccessService {
    
    @Autowired
    private AccessRepository accessRepository;

    @Override
    public List<Access> findAll() {
        return accessRepository.findAll();
    }

    @Override
    public Optional<Access> findById(String id) {
        return accessRepository.findById(id);
    }

    @Override
    public Access save(Access access) {
        return accessRepository.save(access);
    }

    @Override
    public void deleteById(String id) {
        accessRepository.deleteById(id);
    }

    @Override
    public List<Access> findByAccount(Accounts account) {
        return accessRepository.findByAccId(account);
    }
    
    @Override
    public List<Access> findByRole(Roles role) {
        return accessRepository.findByRoleId(role);
    }
    
}
