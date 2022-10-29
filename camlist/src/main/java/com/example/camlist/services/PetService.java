package com.example.camlist.services;

import com.example.camlist.dtos.PetDTO;
import com.example.camlist.entities.product.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
     PetDTO addPet(PetDTO petDTO);
     Pet findById(Integer id);
     List<PetDTO> findByTag(String tag);
}
