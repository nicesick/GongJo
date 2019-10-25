package com.vo;

import java.sql.Date;

public class CarGroup {
	String user_id;
	String car_id;
	Date car_date;
	String car_stat;
	
	public CarGroup() {
		super();
	}

	public CarGroup(String user_id, String car_id) {
		this.user_id = user_id;
		this.car_id = car_id;
	}
	
	public CarGroup(String user_id, String car_id, Date car_date, String car_stat) {
		super();
		this.user_id = user_id;
		this.car_id = car_id;
		this.car_date = car_date;
		this.car_stat = car_stat;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public Date getCar_date() {
		return car_date;
	}

	public void setCar_date(Date car_date) {
		this.car_date = car_date;
	}

	public String getCar_stat() {
		return car_stat;
	}

	public void setCar_stat(String car_stat) {
		this.car_stat = car_stat;
	}

	@Override
	public String toString() {
		return "CarGroup [user_id=" + user_id + ", car_id=" + car_id + ", car_date=" + car_date + ", car_stat="
				+ car_stat + "]";
	}
}
