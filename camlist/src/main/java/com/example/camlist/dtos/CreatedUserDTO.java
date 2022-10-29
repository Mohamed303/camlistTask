package com.example.camlist.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@ApiModel("Created User Account")
@Builder
public class CreatedUserDTO {
    @ApiModelProperty(notes = "userName",position = 1)
    private String username;
    @ApiModelProperty(notes = "password",position = 2)
    private String password;
}
