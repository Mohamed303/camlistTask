package com.example.camlist.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("user info")
@Data
@NoArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "username is mandatory")
    @ApiModelProperty(notes = "username", example = "username10",position = 1)
    private String username;

    @NotNull(message = "firstName is mandatory")
    @ApiModelProperty(notes = "First Name", example = "john",position = 2)
    private String firstName;

    @NotNull(message = "lastName is mandatory")
    @ApiModelProperty(notes = "Last Name", example = "snow",position = 3)
    private String lastName;

    @NotNull(message = "email is mandatory")
    @ApiModelProperty(notes = "email ", example = "johnsnow@email.com",position = 4)
    private String email;


    @NotNull(message = "password is mandatory")
    @ApiModelProperty(notes = "password", example = "62d&sd6^oi",position = 5)
    private String password;

    @NotNull(message = "phoneNumber is mandatory")
    @ApiModelProperty(notes = "phone number", example = "+23412323",position = 6)
    private String phoneNumber;


    @ApiModelProperty(notes = "phone number", example = "0",position = 7)
    private Integer userStatus;


}
