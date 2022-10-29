package com.example.camlist.services;

import com.example.camlist.dtos.CreatedUserDTO;
import com.example.camlist.dtos.UserDTO;
import com.example.camlist.entities.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

public interface UserService extends UserDetailsService {

     CreatedUserDTO createUser(UserDTO userDTO);
     User findUserByUserNameAndPassword(String username,String Password);
     User getCurrentUser(String username);
     ResponseEntity<Map<String, String>> login(CreatedUserDTO createdUserDTO);

}
