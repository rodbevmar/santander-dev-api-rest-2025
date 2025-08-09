package me.dio.santander_dev_api_rest_2025.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.santander_dev_api_rest_2025.domain.model.Account;
import me.dio.santander_dev_api_rest_2025.domain.repository.AccountRepository;
import me.dio.santander_dev_api_rest_2025.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Account create(Account accountToCreate) {
        if (accountToCreate.getId() != null && accountRepository.existsById(accountToCreate.getId())) {
            throw new IllegalArgumentException("Account with this ID already exists");
        }
        return accountRepository.save(accountToCreate);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}