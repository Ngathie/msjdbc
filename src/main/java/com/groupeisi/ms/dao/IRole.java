package com.groupeisi.ms.dao;

import java.util.List;

import com.groupeisi.ms.entities.Role;

public interface IRole {
	public int save(Role role);
	public int update(Role role);
	public int delete(int id);
	public Role find(int id);
	public List<Role> findAll();
	
	

}
