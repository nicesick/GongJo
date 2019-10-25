package com.mapper;

import com.vo.CarStatus;

public interface carStatusMapper {
	public void insert(CarStatus carStatus);
	public void update(CarStatus carStatus);
	public void delete(String key);
	public CarStatus select(String key);
}
