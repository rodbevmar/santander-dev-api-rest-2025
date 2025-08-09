package me.dio.santander_dev_api_rest_2025.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.santander_dev_api_rest_2025.domain.model.User;
import me.dio.santander_dev_api_rest_2025.domain.repository.UserRepository;
import me.dio.santander_dev_api_rest_2025.service.UserService;

///* Boa pratica: não expor a implementação da minha classe de serviço */
@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    // Construtor para injeção de dependência
    // Boa pratica: injetar o repositório no construtor
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Implement methods from UserService interface here
    @Override
    public User findById(Long id) {
        // orElseThrow(null); // Boa prática: não passar null para orElseThrow 
        // Boa prática : lançar exceção específica ao invés de NoSuchElementException
        // Boa prática: usar Optional para evitar NullPointerException
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        // Verifica se o ID já existe
        // Boa prática: verificar se o ID já existe antes de criar um novo usuário
        // Boa prática: lançar exceção específica ao invés de IllegalArgumentException
        // Boa prática: evitar duplicação de código
        if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("User with this ID already exists");
        }
        // Verifica se já existe um usuário com o mesmo número de conta
        // Boa prática: verificar se já existe um usuário com o mesmo número de conta
        // Boa prática: lançar exceção específica ao invés de IllegalArgumentException
        // Boa prática: evitar duplicação de código
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("User with this account number already exists");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    // Boa prática: retornar uma lista vazia ao invés de null
    // Boa prática: usar o método findAll do repositório para obter todos os usuários
    // Boa prática: evitar duplicação de código
    public List<User> findAll() {
        return userRepository.findAll();
    }

    
}
