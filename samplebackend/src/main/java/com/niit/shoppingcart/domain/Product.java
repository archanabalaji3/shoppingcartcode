package com.niit.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
@Table
public class Product  {
	
	@Id
	private String id;
	private String name;
	private String description;
	private int price;
	private String categoryId;
	private String supplierId;
	@Transient
	MultipartFile pimage;
	
	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@ManyToOne
	@JoinColumn(name = "categoryId", updatable = false, insertable = false, nullable = false)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "supplierid", nullable = false, updatable = false, insertable = false)
	private Supplier supplier;

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

	public String getSupplierId() {
		return supplierId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	
}
