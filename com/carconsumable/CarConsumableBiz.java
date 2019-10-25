package com.carconsumable;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.CarConsumable;

@Component("CarConsumableBiz")
public class CarConsumableBiz implements Biz<String, CarConsumable> {

	@Resource(name = "CarConsumableDao")
	Dao<String, CarConsumable> carConsumableDao;
	
	@Override
	public void insert(CarConsumable v) {
		carConsumableDao.insert(v);
	}

	@Override
	public void update(CarConsumable v) {
		carConsumableDao.update(v);
	}

	@Override
	public void delete(String k) {
		carConsumableDao.delete(k);
	}

	@Override
	public CarConsumable select(String k) {
		CarConsumable carConsumable = carConsumableDao.select(k);
		
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
