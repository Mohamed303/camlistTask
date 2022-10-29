package com.example.camlist.repositories;

import com.example.camlist.entities.product.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PetRepository extends JpaRepository<Pet, Integer> {
    @Query(value = "SELECT p FROM Pet p WHERE p.id = :id")
   Pet findByIdCustom(@Param("id") Integer id);
}
