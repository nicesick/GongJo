package com.mapper;

import java.util.ArrayList;
import com.vo.Car;

public interface carMapper {
	public void insert(Car car);
	public void update(Car car);
	public void delete(String key);
	public Car select(String key);
	public ArrayList<Car> selects(String key);
}
