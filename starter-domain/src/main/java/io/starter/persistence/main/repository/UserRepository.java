package io.starter.persistence.main.repository;

import io.starter.persistence.main.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserById(String id);
    public  User findUserByEmail(String email);
    public  List<User> findUsersByEmail(String email);
}
