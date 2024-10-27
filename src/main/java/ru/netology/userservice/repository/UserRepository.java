package ru.netology.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
