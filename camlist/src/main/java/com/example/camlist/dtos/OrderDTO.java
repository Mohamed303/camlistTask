package com.example.camlist.dtos;

import com.example.camlist.entities.product.Pet;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@ApiModel("Order info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "petId", example = "1",position = 1)
    private Integer petId;

    @ApiModelProperty(notes = "shipDate", example = "yyyy-mm-dd HH:mm:ss",position = 2)
    @DateTimeFormat (pattern = "Yyyy-mm-dd HH:mm:ss")
    @JsonFormat(pattern = "Yyyy-mm-dd HH:mm:ss")
    private Date shipDate;

    @ApiModelProperty(notes = "status", example = "approved",position = 3)
    private String status;


}
