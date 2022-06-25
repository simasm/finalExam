package it.akademija.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Product {
	@Transient
	private static long idgen = 1;
	@Column
	private long id;
	@Column
	private long quantity;
	@Column
	private double price;
	@Column
	private String title;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dbid;
	
	public Product() { }
	public Product(String title, long quantity, double price) {
		super();
		this.title = title;
		this.quantity = quantity;
		this.price = price;
		this.id = idgen++;;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	 
	public void setProduct( String title, long quantity, double price) {
		this.quantity = quantity;
		this.price = price;
		this.title = title;
	}
	 
 
	public void setTitle(String title) {
		this.title = title;
	}
	public long getQuantity() {
		return quantity;
	}
 	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
 	public void setPrice(double price) {
		this.price = price;
	}
 	
 	public long getId() {
 		return this.id;
 	}
 	
 
}
