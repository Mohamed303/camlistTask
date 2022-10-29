package com.example.camlist.entities.user;

import com.example.camlist.entities.store.Order;
import com.example.camlist.entities.product.Pet;
import com.example.camlist.entities.store.Bid;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;

    private String firstName;

    private String lastName;

    private String email;

    @Column(unique = true)
    private String phoneNumber;

    private String password;

    private Integer userStatus = 1;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    @OneToMany(mappedBy = "buyer")
    private List<Order> orders;

    @OneToMany(mappedBy = "userBids")
    private List<Bid> bids;

    public User() {
    }


    public static class Builder{
        private Integer id;

        private String username;

        private String firstName;

        private String lastName;

        private String email;

        private String phoneNumber;

        private String password;

        private Integer userStatus = 1;

        private List<Pet> pets;

        private List<Order> orders;

        private List<Bid> bids;

        public Builder() {
        }

        public Builder id(Integer id) {
            this.id=id;
            return this;
        }

        public Builder username(String username) {
            this.username=username;
            return this;
        }

        public Builder firstName( String firstName) {
            this.firstName= firstName;
            return this;
        }

        public Builder lastName(String lastName) {
             this.lastName=lastName;
             return this;
        }

        public Builder email(String email) {
             this.email = email;
             return this;
        }

        public Builder phoneNumber(String phoneNumber) {
             this.phoneNumber = phoneNumber;
             return this;
        }

        public Builder password(String password) {
             this.password=password;
             return this;
        }

        public Builder userStatus(Integer userStatus) {
             this.userStatus = userStatus;
             return this;
        }

        public Builder pets(List<Pet> pets) {
            this.pets = pets;
            return this;
        }

        public Builder orders(List<Order> orders) {
             this.orders=orders;
             return this;
        }

        public Builder bid(List<Bid> bids) {
            this.bids = bids;
            return this;
        }
        public User build(){
            final User user=new User();
            user.setId(this.id);

            user.setUsername(this.username);

            user.setFirstName(this.firstName);

            user.setLastName(this.lastName);

            user.setEmail(this.email);

            user.setPhoneNumber(this.phoneNumber);

            user.setPassword(this.password);

            user.setUserStatus(this.userStatus);

            user.setPets(this.pets);

            user.setOrders(this.orders);

            user.setBids(this.bids);

            return user;
        }
    }
}
