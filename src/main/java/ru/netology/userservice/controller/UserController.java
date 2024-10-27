package ru.netology.userservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.userservice.dto.CreateUserRequestDTO;
import ru.netology.userservice.entity.User;
import ru.netology.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users/api/v1")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public Long saveUser(@RequestBody CreateUserRequestDTO request) {
        return service.createUser(request);
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return service.getAllUsers();
    }

    @PatchMapping("/update/{id}")
    public User updateUser(@RequestBody CreateUserRequestDTO request,
                           @PathVariable Long id) {
        return service.updateUser(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {
        service.deleteUser(id);
    }
}
