package com.mapper;

import com.vo.CarConsumable;

public interface carConsumableMapper {
	public void insert(CarConsumable carConsumable);
	public void update(CarConsumable carConsumable);
	public void delete(String key);
	public CarConsumable select(String key);
}
