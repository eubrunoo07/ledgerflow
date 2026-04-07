package eubrunoo07.projects.account_service.service;

import eubrunoo07.projects.account_service.domain.model.Account;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.UUID;

public interface AccountService {
    Account createAccount(String ownerName);
    void deposit(UUID id, BigDecimal amount);
}
