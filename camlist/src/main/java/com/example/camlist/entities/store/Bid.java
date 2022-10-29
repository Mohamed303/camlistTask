package com.example.camlist.entities.store;

import com.example.camlist.entities.product.Pet;
import com.example.camlist.entities.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bid implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;


    @ManyToOne
    @JoinTable(name = "pet_bid", joinColumns = @JoinColumn(name = "bid_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private Pet petBids;


    @ManyToOne
    @JoinTable(name = "usr_bid", joinColumns = @JoinColumn(name = "bid_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User userBids;

    private Double price;

    public Bid(Pet petBids, User userBids, Double price) {
        this.petBids = petBids;
        this.userBids = userBids;
        this.price = price;
    }

}
