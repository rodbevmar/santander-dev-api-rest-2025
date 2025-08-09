package me.dio.santander_dev_api_rest_2025.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.santander_dev_api_rest_2025.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String accountNumber);
}