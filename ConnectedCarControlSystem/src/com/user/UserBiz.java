package com.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.User;

@Component("UserBiz")
public class UserBiz implements Biz<String, User> {
	
	@Resource(name="UserDao")
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
	public void delete(User v) {
		userDao.delete(v);
	}

	@Override
	public User select(String k) {
		User user = userDao.select(k);
		
		return user;
	}

	@Override
	public ArrayList<User> selects(String k) {
		return null;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> users = userDao.selectAll();
		
		return users;
	}
}
