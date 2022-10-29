package com.example.camlist.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
@ApiModel("pet info")
@Data
@Builder
public class PetDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "name is mandatory")
    @ApiModelProperty(notes = "name", example = "luly",position = 1)
    private String name;

    @NotNull(message = "price is mandatory")
    @ApiModelProperty(notes = "price", example = "2300.4",position = 2)
    private Double price;

    @NotNull(message = "tag is mandatory")
    @ApiModelProperty(notes = "tag", example = "[\n{\"id\":1 \n, \"name\": \"rottweiler\" }\n]",position = 3)
    private List<TagDTO> tags;

    @NotNull(message = "category is mandatory")
    @ApiModelProperty(notes = "category", example = "\"{\"id\":1 \n, \"name\": \"dog\" }",position = 4)
    private CategoryDTO petCategory;

    @ApiModelProperty(notes = "status", example = "available",position = 5)
    private String petStatus;


    private Integer petId;

}
