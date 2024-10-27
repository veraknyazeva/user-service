package ru.netology.userservice.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.netology.userservice.dto.CreateUserRequestDTO;
import ru.netology.userservice.entity.User;
import ru.netology.userservice.entity.UserRole;
import ru.netology.userservice.exception.NotFoundException;
import ru.netology.userservice.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
    private final RoleService roleService;

    public UserService(UserRepository repository, RoleService roleService) {
        this.repository = repository;
        this.roleService = roleService;
    }

    public Long createUser(CreateUserRequestDTO request) {
        String email = request.getEmail();
        String password = request.getPassword();
        String name = request.getName();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setRole(roleService.getRole(UserRole.ROLE_USER));
        repository.save(user);
        return user.getId();
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser(CreateUserRequestDTO request, Long id) {
        Optional<User> userOptional = repository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(Objects.nonNull(request.getEmail()) && (!request.getEmail().isEmpty())){
                user.setEmail(request.getEmail());
            }
            if(!StringUtils.isEmpty(request.getPassword())){
                user.setPassword(request.getPassword());
            }
            if(!StringUtils.isEmpty(request.getName())){
                user.setName(request.getName());
            }
            return repository.save(user);
        }else{
            throw new NotFoundException("Пользователь не найден!");
        }
    }

    public void deleteUser(Long id){
        repository.deleteById(id);
    }
}
