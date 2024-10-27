package ru.netology.userservice.service;

import org.springframework.stereotype.Service;
import ru.netology.userservice.entity.Role;
import ru.netology.userservice.entity.UserRole;
import ru.netology.userservice.repository.UserRoleRepository;

@Service
public class RoleService {
    private final UserRoleRepository roleRepository;

    public RoleService(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRole(UserRole role){
        return roleRepository.findByRoleName(role);
    }
}
