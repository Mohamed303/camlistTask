package com.example.camlist.dtos;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
@ApiModel("BidResult info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidResultDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;
    private Double bitAmount;


}
