package com.car;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.Car;

@Component("CarBiz")
public class CarBiz implements Biz<String, Car> {
	@Resource(name = "CarDao")
	Dao<String, Car> carDao;
	
	@Override
	public void insert(Car v) {
		carDao.insert(v);
	}

	@Override
	public void update(Car v) {
		carDao.update(v);
	}

	@Override
	public void delete(String k) {
		carDao.delete(k);
	}

	@Override
	public Car select(String k) {
		Car car = carDao.select(k);
		
		return car;
	}

	@Override
	public ArrayList<Car> selects(String k) {
		ArrayList<Car> cars = carDao.selects(k);
		return cars;
	}

	@Override
	public ArrayList<Car> selectAll() {
		ArrayList<Car> cars = carDao.selectAll();
		
		return cars;
	}

}
