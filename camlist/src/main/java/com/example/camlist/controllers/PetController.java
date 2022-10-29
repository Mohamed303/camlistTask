package com.example.camlist.controllers;

import com.example.camlist.dtos.PetDTO;
import com.example.camlist.services.PetService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Pet", tags = "Pet")
@RequestMapping("/pet")
@Validated
public class PetController {

    @Autowired
    private PetService petService;


    @PostMapping(value = "/addPet",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Add new Pet")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = PetDTO.class),
            @ApiResponse(code = 400, message = "Missing body field"),
            @ApiResponse(code = 401, message = "Invalid credentials"),
            @ApiResponse(code = 403, message = "Forbidden user"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token") })
    public PetDTO createPet(@Valid @RequestBody PetDTO petDTO) {

        return petService.addPet(petDTO);
    }

    @GetMapping(value = "/findByTag",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Find all pets attached in tag")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = PetDTO.class),
            @ApiResponse(code = 400, message = "Missing body field"),
            @ApiResponse(code = 401, message = "Invalid credentials"),
            @ApiResponse(code = 403, message = "Forbidden user"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token") })
    public List<PetDTO> getByTag(@Valid@RequestParam String tag) {

        return petService.findByTag(tag);
    }

}
