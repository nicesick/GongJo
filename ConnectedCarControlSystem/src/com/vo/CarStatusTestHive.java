package com.vo;

import java.sql.Date;

public class CarStatusTestHive {
	Date car_date;
	String car_id;
	
	public CarStatusTestHive() {
		super();
	}
	
	public CarStatusTestHive(Date car_date, String car_id) {
		super();
		this.car_date = car_date;
		this.car_id = car_id;
	}

	public Date getCar_date() {
		return car_date;
	}

	public void setCar_date(Date car_date) {
		this.car_date = car_date;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	@Override
	public String toString() {
		return "CarStatusTestHive [car_date=" + car_date + ", car_id=" + car_id + "]";
	}
}
