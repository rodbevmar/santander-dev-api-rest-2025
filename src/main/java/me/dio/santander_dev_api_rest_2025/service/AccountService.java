package me.dio.santander_dev_api_rest_2025.service;

import java.util.List;
import me.dio.santander_dev_api_rest_2025.domain.model.Account;

public interface AccountService {

    /**
     * Finds an account by its ID.
     *
     * @param id the ID of the account
     * @return the found account, or null if not found
     */
    Account findById(Long id);

    /**
     * Creates a new account.
     *
     * @param accountToCreate the account to create
     * @return the created account
     */
    Account create(Account accountToCreate);

    /**
     * Finds all accounts.
     *
     * @return a list of all accounts
     */
    List<Account> findAll();
}