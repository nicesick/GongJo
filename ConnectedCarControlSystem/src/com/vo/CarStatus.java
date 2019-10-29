package com.vo;

import java.sql.Date;

public class CarStatus {
	String car_id;
	String car_on;
	int car_speed;
	int car_distance;
	int car_air;
	int car_dust;
	int car_finedust;
	int car_temp;
	int car_ext_temperature;
	int car_ext_dust;
	int car_ext_finedust;
	int car_humidity;
	int car_fuel;
	int car_bat;
	Date car_date;
	String car_hms;
	float car_lat;
	float car_log;
	int car_filter;
	int car_eng_oil;
	int car_brakeoil;
	int car_accoil;
	int car_coolwat;
	int car_accel_pressure;
	int car_brake_pressure;
	int car_driving_count;
	
	public CarStatus() {
		super();
	}

	public CarStatus(String car_id, String car_on, int car_speed, int car_distance, int car_air, int car_dust,
			int car_finedust, int car_temp, int car_ext_temperature, int car_ext_dust, int car_ext_finedust,
			int car_humidity, int car_fuel, int car_bat, Date car_date, String car_hms, float car_lat, float car_log,
			int car_filter, int car_eng_oil, int car_brakeoil, int car_accoil, int car_coolwat, int car_accel_pressure,
			int car_brake_pressure,int car_driving_count) {
		super();
		this.car_id = car_id;
		this.car_on = car_on;
		this.car_speed = car_speed;
		this.car_distance = car_distance;
		this.car_air = car_air;
		this.car_dust = car_dust;
		this.car_finedust = car_finedust;
		this.car_temp = car_temp;
		this.car_ext_temperature = car_ext_temperature;
		this.car_ext_dust = car_ext_dust;
		this.car_ext_finedust = car_ext_finedust;
		this.car_humidity = car_humidity;
		this.car_fuel = car_fuel;
		this.car_bat = car_bat;
		this.car_date = car_date;
		this.car_hms = car_hms;
		this.car_lat = car_lat;
		this.car_log = car_log;
		this.car_filter = car_filter;
		this.car_eng_oil = car_eng_oil;
		this.car_brakeoil = car_brakeoil;
		this.car_accoil = car_accoil;
		this.car_coolwat = car_coolwat;
		this.car_accel_pressure = car_accel_pressure;
		this.car_brake_pressure = car_brake_pressure;
		this.car_driving_count = car_driving_count;
	}

	public String getCar_id() {
		return car_id;
	}
	
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public String getCar_on() {
		return car_on;
	}

	public void setCar_on(String car_on) {
		this.car_on = car_on;
	}

	public int getCar_speed() {
		return car_speed;
	}

	public void setCar_speed(int car_speed) {
		this.car_speed = car_speed;
	}

	public int getCar_distance() {
		return car_distance;
	}

	public void setCar_distance(int car_distance) {
		this.car_distance = car_distance;
	}

	public int getCar_air() {
		return car_air;
	}

	public void setCar_air(int car_air) {
		this.car_air = car_air;
	}

	public int getCar_dust() {
		return car_dust;
	}

	public void setCar_dust(int car_dust) {
		this.car_dust = car_dust;
	}

	public int getCar_finedust() {
		return car_finedust;
	}

	public void setCar_finedust(int car_finedust) {
		this.car_finedust = car_finedust;
	}

	public int getCar_temp() {
		return car_temp;
	}

	public void setCar_temp(int car_temp) {
		this.car_temp = car_temp;
	}

	public int getCar_ext_temperature() {
		return car_ext_temperature;
	}

	public void setCar_ext_temperature(int car_ext_temperature) {
		this.car_ext_temperature = car_ext_temperature;
	}

	public int getCar_ext_dust() {
		return car_ext_dust;
	}

	public void setCar_ext_dust(int car_ext_dust) {
		this.car_ext_dust = car_ext_dust;
	}

	public int getCar_ext_finedust() {
		return car_ext_finedust;
	}

	public void setCar_ext_finedust(int car_ext_finedust) {
		this.car_ext_finedust = car_ext_finedust;
	}

	public int getCar_humidity() {
		return car_humidity;
	}

	public void setCar_humidity(int car_humidity) {
		this.car_humidity = car_humidity;
	}

	public int getCar_fuel() {
		return car_fuel;
	}

	public void setCar_fuel(int car_fuel) {
		this.car_fuel = car_fuel;
	}

	public int getCar_bat() {
		return car_bat;
	}

	public void setCar_bat(int car_bat) {
		this.car_bat = car_bat;
	}

	public Date getCar_date() {
		return car_date;
	}

	public void setCar_date(Date car_date) {
		this.car_date = car_date;
	}

	public String getCar_hms() {
		return car_hms;
	}

	public void setCar_hms(String car_hms) {
		this.car_hms = car_hms;
	}

	public float getCar_lat() {
		return car_lat;
	}

	public void setCar_lat(float car_lat) {
		this.car_lat = car_lat;
	}

	public float getCar_log() {
		return car_log;
	}

	public void setCar_log(float car_log) {
		this.car_log = car_log;
	}

	public int getCar_filter() {
		return car_filter;
	}

	public void setCar_filter(int car_filter) {
		this.car_filter = car_filter;
	}

	public int getCar_eng_oil() {
		return car_eng_oil;
	}

	public void setCar_eng_oil(int car_eng_oil) {
		this.car_eng_oil = car_eng_oil;
	}

	public int getCar_brakeoil() {
		return car_brakeoil;
	}

	public void setCar_brakeoil(int car_brakeoil) {
		this.car_brakeoil = car_brakeoil;
	}

	public int getCar_accoil() {
		return car_accoil;
	}

	public void setCar_accoil(int car_accoil) {
		this.car_accoil = car_accoil;
	}

	public int getCar_coolwat() {
		return car_coolwat;
	}

	public void setCar_coolwat(int car_coolwat) {
		this.car_coolwat = car_coolwat;
	}

	public int getCar_accel_pressure() {
		return car_accel_pressure;
	}

	public void setCar_accel_pressure(int car_accel_pressure) {
		this.car_accel_pressure = car_accel_pressure;
	}

	public int getCar_brake_pressure() {
		return car_brake_pressure;
	}

	public void setCar_brake_pressure(int car_brake_pressure) {
		this.car_brake_pressure = car_brake_pressure;
	}

	public int getCar_driving_count() {
		return car_driving_count;
	}

	public void setCar_driving_count(int car_driving_count) {
		this.car_driving_count = car_driving_count;
	}

	@Override
	public String toString() {
		return "CarStatus [car_id=" + car_id + ", car_on=" + car_on + ", car_speed=" + car_speed + ", car_distance="
				+ car_distance + ", car_air=" + car_air + ", car_dust=" + car_dust + ", car_finedust=" + car_finedust
				+ ", car_temp=" + car_temp + ", car_ext_temperature=" + car_ext_temperature + ", car_ext_dust="
				+ car_ext_dust + ", car_ext_finedust=" + car_ext_finedust + ", car_humidity=" + car_humidity
				+ ", car_fuel=" + car_fuel + ", car_bat=" + car_bat + ", car_date=" + car_date + ", car_hms=" + car_hms
				+ ", car_lat=" + car_lat + ", car_log=" + car_log + ", car_filter=" + car_filter + ", car_eng_oil="
				+ car_eng_oil + ", car_brakeoil=" + car_brakeoil + ", car_accoil=" + car_accoil + ", car_coolwat="
				+ car_coolwat + ", car_accel_pressure=" + car_accel_pressure + ", car_brake_pressure="
				+ car_brake_pressure + ", car_driving_count=" + car_driving_count + "]";
	}


}
