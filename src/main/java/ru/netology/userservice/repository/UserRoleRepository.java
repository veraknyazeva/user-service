package ru.netology.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.netology.userservice.entity.Role;
import ru.netology.userservice.entity.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(UserRole roleName);
}
