package com.mapper;

import com.vo.User;

public interface UserMapper {
	public void insert(User user);
	public void update(User user);
	public void delete(String key);
	public User select(String key);
}
