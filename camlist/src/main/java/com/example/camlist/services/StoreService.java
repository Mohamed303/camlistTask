package com.example.camlist.services;

import com.example.camlist.dtos.*;
import java.util.List;

public interface StoreService {
    TagDTO addTag(TagDTO tagDTO);

    CategoryDTO addCategory(CategoryDTO categoryDTO);


    OrderDTO addOrder(OrderDTO orderDTO);

    BidDTO addBid(BidDTO bidDTO);

    List<BidResultDto> getPids(Integer petId);
}
