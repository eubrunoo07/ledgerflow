package eubrunoo07.projects.account_service.repository;

import eubrunoo07.projects.account_service.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
