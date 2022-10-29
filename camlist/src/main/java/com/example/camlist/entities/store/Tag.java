package com.example.camlist.entities.store;

import com.example.camlist.entities.product.Pet;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @ManyToMany (mappedBy = "tags")
    private List<Pet> pets;

    public Tag(String name){
        this.name=name;
    }

}
