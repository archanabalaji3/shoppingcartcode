package com.niit.shoppingcart.domain;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity          //specify it is not a normal class, it is database entity
@Table
public class Category {
	
	
	@Id
	private String id;
	private String name;
	private String description;
	@OneToMany(mappedBy="category",fetch = FetchType.EAGER)
	private Set<Product> products;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
