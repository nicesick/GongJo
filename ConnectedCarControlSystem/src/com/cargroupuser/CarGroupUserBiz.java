package com.cargroupuser;

import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.frame.Biz;
import com.frame.Dao;
import com.vo.CarGroup;

@Component("CarGroupUserBiz")
public class CarGroupUserBiz implements Biz<String, CarGroup> {

	@Resource(name = "CarGroupUserDao")
	Dao<String, CarGroup> carGroupUserDao;
	
	
	@Override
	public void insert(CarGroup v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CarGroup v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CarGroup select(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CarGroup> selects(String k) {
		ArrayList<CarGroup> carGroups = carGroupUserDao.selects(k);
		
		return carGroups;
	}

	@Override
	public ArrayList<CarGroup> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
