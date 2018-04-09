package com.niit.shoppingcart.domain;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component                        //create singleton instance
@Entity                           //to specify it is going to map to table
@Table                      
public class Cart {
		
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String emailid;
	private String productName;
	private int price;
	private int quantity;
	private String productID;
	
	@Transient
	private int total;
	
	public int getId() {
		return id;
	}
	public void setId() {
		this.id = new Random().nextInt();
	}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
