package com.vo;

public class Car {
	String car_id;
	String car_name;
	String car_type;
	String car_fuel;
	int car_displacement;
	String car_color;
	String car_auto;
	
	public Car() {
		super();
	}
	
	public Car(String car_id, String car_name, String car_type, String car_fuel, int car_displacement, String car_color,
			String car_auto) {
		super();
		this.car_id = car_id;
		this.car_name = car_name;
		this.car_type = car_type;
		this.car_fuel = car_fuel;
		this.car_displacement = car_displacement;
		this.car_color = car_color;
		this.car_auto = car_auto;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public String getCar_fuel() {
		return car_fuel;
	}

	public void setCar_fuel(String car_fuel) {
		this.car_fuel = car_fuel;
	}

	public int getCar_displacement() {
		return car_displacement;
	}

	public void setCar_displacement(int car_displacement) {
		this.car_displacement = car_displacement;
	}

	public String getCar_color() {
		return car_color;
	}

	public void setCar_color(String car_color) {
		this.car_color = car_color;
	}

	public String getCar_auto() {
		return car_auto;
	}

	public void setCar_auto(String car_auto) {
		this.car_auto = car_auto;
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", car_name=" + car_name + ", car_type=" + car_type + ", car_fuel=" + car_fuel
				+ ", car_displacement=" + car_displacement + ", car_color=" + car_color + ", car_auto=" + car_auto
				+ "]";
	}
}
