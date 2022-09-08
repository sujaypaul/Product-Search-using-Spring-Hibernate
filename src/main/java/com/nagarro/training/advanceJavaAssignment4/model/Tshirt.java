package com.nagarro.training.advanceJavaAssignment4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tshirts")
public class Tshirt {
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
//	private int tid;
	@Id
	private String id;
	private String name;
	private String color;
	private String gender;
	private String size;
	private String avalibilty;

	private double price;
	private double rating;

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAvalibilty() {
		return avalibilty;
	}

	public void setAvalibilty(String avalibilty) {
		this.avalibilty = avalibilty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + name + ", color" + color + ", gender=" + gender + ", size=" + size
				+ ", avalibilty=" + avalibilty + "]";
	}

}
