package com.example.camlist.repositories;

import com.example.camlist.entities.product.Pet;
import com.example.camlist.entities.store.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findByIdAndName(Integer id,String name);
    @Query(value = "SELECT t FROM Tag t WHERE t.name = :name")
    Tag findByName(String name);

}
