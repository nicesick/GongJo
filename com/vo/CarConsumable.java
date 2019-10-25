package com.vo;

import java.sql.Date;

public class CarConsumable {
	String car_id;
	int car_filter_alarm;
	int car_eng_oil_alarm;
	int car_brakeoil_alarm;
	int car_accoil_alarm;
	int car_coolwat_alarm;
	Date date_filter;
	Date date_eng_oil;
	Date date_breakoil;
	Date date_accoil;
	Date date_coolwat;
	
	public CarConsumable() {
		super();
	}
	
	public CarConsumable(String car_id, int car_filter_alarm, int car_eng_oil_alarm, int car_brakeoil_alarm,
			int car_accoil_alarm, int car_coolwat_alarm, Date date_filter, Date date_eng_oil, Date date_breakoil,
			Date date_accoil, Date date_coolwat) {
		super();
		this.car_id = car_id;
		this.car_filter_alarm = car_filter_alarm;
		this.car_eng_oil_alarm = car_eng_oil_alarm;
		this.car_brakeoil_alarm = car_brakeoil_alarm;
		this.car_accoil_alarm = car_accoil_alarm;
		this.car_coolwat_alarm = car_coolwat_alarm;
		this.date_filter = date_filter;
		this.date_eng_oil = date_eng_oil;
		this.date_breakoil = date_breakoil;
		this.date_accoil = date_accoil;
		this.date_coolwat = date_coolwat;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public int getCar_filter_alarm() {
		return car_filter_alarm;
	}

	public void setCar_filter_alarm(int car_filter_alarm) {
		this.car_filter_alarm = car_filter_alarm;
	}

	public int getCar_eng_oil_alarm() {
		return car_eng_oil_alarm;
	}

	public void setCar_eng_oil_alarm(int car_eng_oil_alarm) {
		this.car_eng_oil_alarm = car_eng_oil_alarm;
	}

	public int getCar_brakeoil_alarm() {
		return car_brakeoil_alarm;
	}

	public void setCar_brakeoil_alarm(int car_brakeoil_alarm) {
		this.car_brakeoil_alarm = car_brakeoil_alarm;
	}

	public int getCar_accoil_alarm() {
		return car_accoil_alarm;
	}

	public void setCar_accoil_alarm(int car_accoil_alarm) {
		this.car_accoil_alarm = car_accoil_alarm;
	}

	public int getCar_coolwat_alarm() {
		return car_coolwat_alarm;
	}

	public void setCar_coolwat_alarm(int car_coolwat_alarm) {
		this.car_coolwat_alarm = car_coolwat_alarm;
	}

	public Date getDate_filter() {
		return date_filter;
	}

	public void setDate_filter(Date date_filter) {
		this.date_filter = date_filter;
	}

	public Date getDate_eng_oil() {
		return date_eng_oil;
	}

	public void setDate_eng_oil(Date date_eng_oil) {
		this.date_eng_oil = date_eng_oil;
	}

	public Date getDate_breakoil() {
		return date_breakoil;
	}

	public void setDate_breakoil(Date date_breakoil) {
		this.date_breakoil = date_breakoil;
	}

	public Date getDate_accoil() {
		return date_accoil;
	}

	public void setDate_accoil(Date date_accoil) {
		this.date_accoil = date_accoil;
	}

	public Date getDate_coolwat() {
		return date_coolwat;
	}

	public void setDate_coolwat(Date date_coolwat) {
		this.date_coolwat = date_coolwat;
	}

	@Override
	public String toString() {
		return "CarConsumable [car_id=" + car_id + ", car_filter_alarm=" + car_filter_alarm + ", car_eng_oil_alarm="
				+ car_eng_oil_alarm + ", car_brakeoil_alarm=" + car_brakeoil_alarm + ", car_accoil_alarm="
				+ car_accoil_alarm + ", car_coolwat_alarm=" + car_coolwat_alarm + ", date_filter=" + date_filter
				+ ", date_eng_oil=" + date_eng_oil + ", date_breakoil=" + date_breakoil + ", date_accoil=" + date_accoil
				+ ", date_coolwat=" + date_coolwat + "]";
	}
}
