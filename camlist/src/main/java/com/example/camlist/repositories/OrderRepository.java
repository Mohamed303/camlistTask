package com.example.camlist.repositories;

import com.example.camlist.entities.store.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
