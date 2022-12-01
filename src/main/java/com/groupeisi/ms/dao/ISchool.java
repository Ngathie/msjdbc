package com.groupeisi.ms.dao;

import java.util.List;

import com.groupeisi.ms.entities.School;

public interface ISchool {
	public int save(School school);
	public int update(School school);
	public int delete(int id);
	public School find(int id);
	public List<School> findAll();
}
