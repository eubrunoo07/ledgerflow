package eubrunoo07.projects.account_service.controller;

import eubrunoo07.projects.account_service.dto.AccountResponseData;
import eubrunoo07.projects.account_service.dto.CreateNewAccount;
import eubrunoo07.projects.account_service.dto.DepositRequest;
import eubrunoo07.projects.account_service.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/api/ledgerflow/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create-account")
    public ResponseEntity<AccountResponseData> createAccount(@RequestBody@Valid CreateNewAccount request){
        accountService.createAccount(request.getOwnerName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Void> deposit(@PathVariable UUID id, @RequestBody@Valid DepositRequest request){
        accountService.deposit(id, request.getAmount());
        return ResponseEntity.ok().build();
    }
}
