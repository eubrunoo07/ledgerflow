package eubrunoo07.projects.account_service.service;

import eubrunoo07.projects.account_service.domain.model.Account;
import jakarta.validation.constraints.NotBlank;

public interface AccountService {
    Account createAccount(String ownerName);
}
