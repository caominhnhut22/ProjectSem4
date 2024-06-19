package prjS4.ProjectSem4.securities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prjS4.ProjectSem4.entities.Accounts;
import prjS4.ProjectSem4.securities.repo.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Accounts> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Accounts> findById(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public Accounts findByEmail(String email) {
        return accountRepository.findByUserEmail(email);
    }
    
    @Override
    public Accounts findByUserName(String userName) {
        return accountRepository.findByUserName(userName);
    }
    

    @Override
    public Accounts save(Accounts account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteById(String id) {
        accountRepository.deleteById(id);
    }

}
