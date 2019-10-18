package com.carconsumable;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.Dao;
import com.mapper.carConsumableMapper;
import com.vo.CarConsumable;

@Component("CarConsumableDao")
public class CarConsumableDao implements Dao<String, CarConsumable> {

	@Resource(name = "carConsumableMapper")
	carConsumableMapper carConsumableMapper;
	
	@Override
	public void insert(CarConsumable v) {
		carConsumableMapper.insert(v);
	}

	@Override
	public void update(CarConsumable v) {
		carConsumableMapper.update(v);
	}

	@Override
	public void delete(String k) {
		carConsumableMapper.delete(k);
	}

	@Override
	public CarConsumable select(String k) {
		CarConsumable carConsumable = carConsumableMapper.select(k);
		
		return carConsumable;
	}

	@Override
	public ArrayList<CarConsumable> selects(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CarConsumable> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
