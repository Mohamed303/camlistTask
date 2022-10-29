package com.example.camlist.repositories;

import com.example.camlist.entities.store.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Integer> {
    @Query(value = "SELECT b FROM Bid b WHERE b.userBids.id =:userId and b.petBids.id =:petId")
    Bid findByUserIdAndPetId(@Param("userId") Integer userId, @Param("petId") Integer petId);
}
