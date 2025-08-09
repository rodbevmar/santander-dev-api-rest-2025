package me.dio.santander_dev_api_rest_2025.service;

import java.util.List;

import me.dio.santander_dev_api_rest_2025.domain.model.User;

public interface UserService {
    /**
     * Finds a user by their ID.
     *
     * @param id the ID of the user to find
     * @return the found user, or null if no user with the given ID exists
     */
    User findById(Long id);

    /**
     * Creates a new user.
     *
     * @param userToCreate the user to create
     * @return the created user
     */
    User create(User userToCreate);

    /**
     * Finds all users.
     *
     * @return a list of all users
     */
    List<User> findAll();
}
