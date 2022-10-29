package com.example.camlist.controllers;

import com.example.camlist.dtos.CreatedUserDTO;
import com.example.camlist.dtos.UserDTO;
import com.example.camlist.entities.user.User;
import com.example.camlist.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@RestController
@Api(value = "User", tags = "User")

public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(value = "user",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create New User")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = CreatedUserDTO.class),
            @ApiResponse(code = 400, message = "Missing body field"),
            @ApiResponse(code = 401, message = "Invalid credentials"),
            @ApiResponse(code = 403, message = "Forbidden user"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public CreatedUserDTO createUser(@Valid @RequestBody UserDTO userDTO) {

    return userService.createUser(userDTO);
    }

    @PostMapping(value = "login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("login User")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Missing body field"),
            @ApiResponse(code = 401, message = "Invalid credentials"),
            @ApiResponse(code = 403, message = "Forbidden user"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody CreatedUserDTO createdUserDTO) {

        return userService.login(createdUserDTO);
    }
    @GetMapping(value = "getUser", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Create New User")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = CreatedUserDTO.class),
            @ApiResponse(code = 400, message = "Missing body field"),
            @ApiResponse(code = 401, message = "Invalid credentials"),
            @ApiResponse(code = 403, message = "Forbidden user"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public User getUser(@RequestParam String userName,@RequestParam String password) {

        return userService.findUserByUserNameAndPassword(userName,password);
    }

}
