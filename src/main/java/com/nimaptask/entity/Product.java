package com.nimaptask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String discription;
	
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String title, String discription, double price, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.discription = discription;
		this.price = price;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", discription=" + discription + ", price=" + price
				+ ", category=" + category + "]";
	}
	
	
	
	
}
