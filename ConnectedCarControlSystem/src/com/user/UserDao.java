package com.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.Dao;
import com.mapper.userMapper;
import com.vo.User;

@Component("UserDao")
public class UserDao implements Dao<String, User> {

	@Resource(name="userMapper")
	userMapper userMapper;
	
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

	@Override
	public ArrayList<User> selects(String k) {
		return null;
	}

	@Override
	public ArrayList<User> selectAll() {
		return null;
	}
}
