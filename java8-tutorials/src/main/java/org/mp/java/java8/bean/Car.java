package org.mp.java.java8.bean;

/**
 * 
 * @author manojmitharampawa
 *
 */
public class Car {
	private Integer id;
	private String make;
	private String model;
	private String color;
	private Integer year;
	private Double price;

	public Car(Integer id, String make, String model, String color, Integer year, Double price) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public Integer getYear() {
		return year;
	}

	public Double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", color=" + color + ", year=" + year
				+ ", price=" + price + "]";
	}

}
