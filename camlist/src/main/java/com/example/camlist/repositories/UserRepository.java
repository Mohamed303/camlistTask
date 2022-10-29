package com.example.camlist.repositories;

import com.example.camlist.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u FROM User u WHERE u.username = :username and u.password = :password")
    User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
    User findByUsername(String username);
}
