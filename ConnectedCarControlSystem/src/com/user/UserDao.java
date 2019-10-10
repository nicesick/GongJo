package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frame.Dao;
import com.mapper.UserMapper;
import com.vo.User;

@Component("userDao")
public class UserDao implements Dao<String, User> {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public void insert(User v) {
		userMapper.insert(v);
	}

	@Override
	public void update(User v) {
		userMapper.update(v);
	}

	@Override
	public void delete(String k) {
		userMapper.delete(k);
	}

	@Override
	public User select(String k) {
		User user = userMapper.select(k);
		
		return user;
	}
}
