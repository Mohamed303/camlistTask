package com.example.camlist.services.serviceImpl;

import com.example.camlist.Enums.ErrorMessages;
import com.example.camlist.Enums.Roles;
import com.example.camlist.config.JwtTokenUtil;
import com.example.camlist.dtos.CreatedUserDTO;
import com.example.camlist.dtos.UserDTO;
import com.example.camlist.entities.user.User;
import com.example.camlist.exceptions.ResourceNotExistException;
import com.example.camlist.exceptions.ResourceSaveException;
import com.example.camlist.exceptions.UserNotFoundException;
import com.example.camlist.repositories.UserRepository;
import com.example.camlist.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserServiceImpl implements UserService , UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    public UserServiceImpl(UserRepository userRepository,JwtTokenUtil jwtTokenUtil){
        this.userRepository=userRepository;
        this.jwtTokenUtil=jwtTokenUtil;
    }

    @Transactional
    public CreatedUserDTO createUser(UserDTO userDTO){
        User user= new User.Builder().username(userDTO.getUsername())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .phoneNumber(userDTO.getPhoneNumber())
                .userStatus(userDTO.getUserStatus()).build();
        try {
            logger.info("convert userDto to entity and heading to save it.....");

            userRepository.save(user);

            logger.info("user saved.....");
        }
        catch (Exception exception){

           logger.error("exception while saving user "+ exception.getMessage());
           exception.printStackTrace();
           throw new ResourceSaveException(exception.getMessage());
        }

       return CreatedUserDTO.builder()
               .username(userDTO.getUsername()).
               password(userDTO.getPassword()).build();
    }

    public User findUserByUserNameAndPassword(String username,String password)
    {
        User user= userRepository.findByUsernameAndPassword(username,password);
        if(user==null || !Objects.nonNull(user))
            throw new UserNotFoundException(ErrorMessages.USER_NOT_FOUND.getValue());
        return user;
    }
    public User getCurrentUser(String username)
    {
        User user=userRepository.findByUsername(username);
        if (Objects.nonNull(user))
            return user;
        throw new ResourceNotExistException(ErrorMessages.USER_NOT_FOUND.getValue());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getCurrentUser(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        } else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

                authorities.add(new SimpleGrantedAuthority(Roles.ROLE_USER.name()));


            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }
    public ResponseEntity<Map<String, String>> login(CreatedUserDTO createdUserDTO) {
        User user = findUserByUserNameAndPassword(createdUserDTO.getUsername(),createdUserDTO.getPassword());

        String accessToken = jwtTokenUtil.generateAccessToken(user);

        Map<String, String> tokens = new HashMap<>();

        tokens.put("access_token", accessToken);

        return ResponseEntity.ok().body(tokens);
    }


}
