package me.dio.santander_dev_api_rest_2025.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.santander_dev_api_rest_2025.domain.model.User;
import me.dio.santander_dev_api_rest_2025.service.UserService;

@RestController
@RequestMapping("/users") // Path para exportar nossos endepoints
// Boa prática: usar plural para o nome do recurso
// Boa prática: usar @RestController para indicar que é um controlador REST
// Boa prática: usar @RequestMapping para definir o caminho base do controlador
// Boa prática: manter o controlador vazio para evitar confusão
public class UserController {

    // Boa prática: injetar o serviço de usuário
    // Boa prática: usar o nome do serviço no singular
    // Só tenho o contrato da minha camada de serviço, não tenho a implementação 
    private final UserService userService;  

    // Construtor para injeção de dependência
    // Boa prática: injetar o serviço no construtor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Classe do Spring WEB (ResponseEntity)
    // Ideial é criar UserDTO(ResponseEntity<UserDTO> ) para expor somente os dados necessários
    // Boa prática: usar @PostMapping para mapear requisições POST
    // Boa prática: usar @RequestBody para receber o corpo da requisição
    // Boa prática: retornar ResponseEntity para encapsular a resposta
    // .path("/{id}") para construir a URI do recurso criado
    // .buildAndExpand(userCreated.getId()) para expandir o ID do usuário criado
    // .toUri() para converter em URI
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User userToCreate) {
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        // Retorna o status 201 Created com a localização do novo recurso
        return ResponseEntity.created(location).body(userCreated);
    }

    @GetMapping("/{id}")
    // Boa prática: usar @GetMapping para mapear requisições GET
    // Boa prática: usar @RequestBody para receber o corpo da requisição
    // Boa prática: retornar ResponseEntity para encapsular a resposta
    // Boa prática: usar o método findById do serviço para buscar o usuário
    // @PathVariable para extrair o ID do usuário da URL
    // Exemplo: http://localhost:8080/users/1
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }


}
