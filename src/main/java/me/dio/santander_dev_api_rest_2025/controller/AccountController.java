package me.dio.santander_dev_api_rest_2025.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.santander_dev_api_rest_2025.domain.model.Account;
import me.dio.santander_dev_api_rest_2025.service.AccountService;

@RestController
@RequestMapping("/accounts") // Boa prática: plural para o recurso
public class AccountController {

    private final AccountService accountService; // Injeção do serviço

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account accountToCreate) {
        var accountCreated = accountService.create(accountToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(accountCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(accountCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        var account = accountService.findById(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        return ResponseEntity.ok(accountService.findAll());
    }
}