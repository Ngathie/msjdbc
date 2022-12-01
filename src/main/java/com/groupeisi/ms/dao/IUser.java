package com.groupeisi.ms.dao;

import java.util.List;

import com.groupeisi.ms.entities.User;

public interface IUser {
	public int save(User user);
	public int update(User user);
	public int delete(int id);
	public User find(int id);
	public List<User> findAll();
}
