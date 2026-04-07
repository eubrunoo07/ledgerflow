package eubrunoo07.projects.account_service.service.impl;

import eubrunoo07.projects.account_service.domain.model.Account;
import eubrunoo07.projects.account_service.repository.AccountRepository;
import eubrunoo07.projects.account_service.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(String ownerName) {
        Account account = new Account(ownerName);
        return accountRepository.save(account);
    }
}
