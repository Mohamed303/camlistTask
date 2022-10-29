package com.example.camlist.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("Bid info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "petId is mandatory")
    @ApiModelProperty(notes = "petId", example = "1",position = 1)
    private Integer petId;

    @NotNull(message = "bidAmount is mandatory")
    @ApiModelProperty(notes = "bidAmount", example = "132.4",position = 2)
    private Double bitAmount;

}
