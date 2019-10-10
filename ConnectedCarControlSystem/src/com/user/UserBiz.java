package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.User;

@Component("userBiz")
public class UserBiz implements Biz<String, User> {
	
	@Autowired
	@Qualifier("userDao")
	Dao<String, User> userDao;
	
	@Override
	public void insert(User v) {
		userDao.insert(v);
	}

	@Override
	public void update(User v) {
		userDao.update(v);
	}

	@Override
	public void delete(String k) {
		userDao.delete(k);
	}

	@Override
	public User select(String k) {
		User user = userDao.select(k);
		
		return user;
	}

}
