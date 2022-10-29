package com.example.camlist.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("Category info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(notes = "id", example = "1",position = 1)
    private Integer id;

    @NotNull(message = "name is mandatory")
    @ApiModelProperty(notes = "name", example = "dog",position = 2)
    private String name;
}
