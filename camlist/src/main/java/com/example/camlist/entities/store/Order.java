package com.example.camlist.entities.store;

import com.example.camlist.entities.product.Pet;
import com.example.camlist.entities.user.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "tb_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "order_date")
	private Date orderDate;

	@OneToOne
	@JoinTable(name = "pet_order", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
	private Pet petOrder;


	@ManyToOne
	@JoinTable(name = "user_order", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private User buyer;


}
