package com.example.camlist.repositories;

import com.example.camlist.entities.store.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByIdAndName(Integer id, String name);
    Category findByName(String name);
}
