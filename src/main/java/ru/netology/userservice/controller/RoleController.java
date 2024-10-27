package ru.netology.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.userservice.entity.Role;
import ru.netology.userservice.repository.UserRoleRepository;

import java.util.List;

@RestController
@RequestMapping("/roles/api/v1")
public class RoleController {
    private final UserRoleRepository roleRepository;

    public RoleController(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @GetMapping("/findAll")
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
