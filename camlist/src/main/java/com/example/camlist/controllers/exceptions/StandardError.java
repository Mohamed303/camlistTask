package com.example.camlist.controllers.exceptions;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Date timestamp;
    private Integer status;
    private String message;
    private String path;
    
    public StandardError(){}


    
}