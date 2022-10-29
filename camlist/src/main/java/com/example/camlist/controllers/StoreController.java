package com.example.camlist.controllers;

import com.example.camlist.dtos.*;
import com.example.camlist.services.StoreService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Store", tags = "Store")
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping(value = "/addTag",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create New Tag")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = TagDTO.class),
            @ApiResponse(code = 400, message = "Missing body field"),
            @ApiResponse(code = 401, message = "Invalid credentials"),
            @ApiResponse(code = 403, message = "Forbidden user"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public TagDTO createTag(@Valid @RequestBody TagDTO tagDTO) {

        return storeService.addTag(tagDTO);
    }

    @PostMapping(value = "/addCategory",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create New Category")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = CategoryDTO.class),
            @ApiResponse(code = 400, message = "Missing body field"),
            @ApiResponse(code = 401, message = "Invalid credentials"),
            @ApiResponse(code = 403, message = "Forbidden user"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public CategoryDTO createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {

        return storeService.addCategory(categoryDTO);
    }

    @PostMapping(value = "/order",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create New Order")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = OrderDTO.class),
            @ApiResponse(code = 400, message = "Missing body field"),
            @ApiResponse(code = 401, message = "Invalid credentials"),
            @ApiResponse(code = 403, message = "Forbidden user"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token") })
    public OrderDTO createOrder(@Valid @RequestBody OrderDTO orderDTO) {

        return storeService.addOrder(orderDTO);
    }

    @PostMapping(value = "/addBid",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("add New Bid on Pet")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = OrderDTO.class),
            @ApiResponse(code = 400, message = "Missing body field"),
            @ApiResponse(code = 401, message = "Invalid credentials"),
            @ApiResponse(code = 403, message = "Forbidden user"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token") })
    public BidDTO createBids(@Valid @RequestBody BidDTO bidDTO) {

        return storeService.addBid(bidDTO);
    }

    @GetMapping(value = "/getBids",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Get all on Pet")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = BidResultDto.class),
            @ApiResponse(code = 400, message = "Missing body field"),
            @ApiResponse(code = 401, message = "Invalid credentials"),
            @ApiResponse(code = 403, message = "Forbidden user"),
            @ApiResponse(code = 404, message = "Resource not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    @ApiImplicitParams({ @ApiImplicitParam(name = "Authorization", value = "Bearer Token", required = true, allowEmptyValue = false, paramType = "header", example = "Bearer access_token") })
    public List<BidResultDto> getBids(@Valid @RequestParam Integer petId) {

        return storeService.getPids(petId);
    }
}
