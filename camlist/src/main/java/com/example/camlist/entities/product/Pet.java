package com.example.camlist.entities.product;

import com.example.camlist.entities.store.Category;
import com.example.camlist.entities.store.Order;
import com.example.camlist.entities.store.Bid;
import com.example.camlist.entities.store.Tag;
import com.example.camlist.entities.user.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private Double price;

	@Column(name = "pet_status")
	private String petStatus;

	@ManyToMany
	@JoinTable(name = "pet_Tags", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;

	@ManyToOne
	@JoinTable(name = "pet_category", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Category petCategory;

	@ManyToOne
	@JoinTable(name = "pet_owner", joinColumns = @JoinColumn(name = "pet_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private User owner;


	@OneToMany(mappedBy = "petBids")
	private List<Bid> bids;

	@OneToOne(mappedBy = "petOrder")
	private Order order;



	public static class Builder{

		private Integer id;

		private String name;

		private Double price;

		private String petStatus;

		private List<Tag> tags;

		private Category petCategory;

		private User owner;

		private List<Bid> bids;

		private Order order;

		public Builder() {
		}

		public Builder id(Integer id) {
			this.id=id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder price(Double price) {
			this.price = price;
			return this;
		}

		public Builder petStatus(String petStatus) {
			this.petStatus = petStatus;
			return this;
		}

		public Builder tags(List<Tag> tags) {
			this.tags = tags;
			return this;
		}

		public Builder petCategory(Category petCategory) {
			this.petCategory = petCategory;
			return this;
		}

		public Builder owner(User owner) {
			this.owner = owner;
			return this;
		}

		public Builder bids(List<Bid> bids) {
			this.bids = bids;
			return this;
		}

		public Builder order(Order order) {
			this.order = order;
			return this;
		}
		public Pet build()
		{
			final Pet pet = new Pet();
			pet.setId(this.id);
			pet.setName(this.name);
			pet.setPrice(this.price);
			pet.setPetStatus(this.petStatus);
			pet.setTags(this.tags);
			pet.setPetCategory(this.petCategory);
			pet.setOwner(this.owner);
			pet.setBids(this.bids);
			pet.setOrder(this.order);
			return pet;
		}
	}

}
