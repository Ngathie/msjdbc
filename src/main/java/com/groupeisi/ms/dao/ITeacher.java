package com.groupeisi.ms.dao;

import java.util.List;

import com.groupeisi.ms.entities.Teacher;

public interface ITeacher {
	public int save(Teacher teacher);
	public int update(Teacher teacher);
	public int delete(int id);
	public Teacher find(int id);
	public List<Teacher> findAll();
}
