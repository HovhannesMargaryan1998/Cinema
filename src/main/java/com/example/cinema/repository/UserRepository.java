package com.example.cinema.repository;

import com.example.cinema.entity.userdetail.Role;
import com.example.cinema.entity.userdetail.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String username);
    List<User> findAll();
    @Query(value = "SELECT COUNT(id) FROM user WHERE role = 'USER'", nativeQuery = true)
    int countAllUsers();

    @Query(value = "SELECT * FROM USER WHERE role = 'USER' ORDER BY id DESC LIMIT 5 ", nativeQuery = true)
    List<User> findLastFiveUsers();

}
