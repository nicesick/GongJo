package com.mapper;

import java.util.ArrayList;

import com.vo.User;

public interface userMapper {
	public void insert(User user);
	public void update(User user);
	public void delete(User user);
	public User select(String key);
	public ArrayList<User> selectAll();
} 
