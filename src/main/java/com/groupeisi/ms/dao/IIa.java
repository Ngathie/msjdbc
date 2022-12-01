package com.groupeisi.ms.dao;

import java.util.List;

import com.groupeisi.ms.entities.Ia;

public interface IIa {
	public int save(Ia ia);
	public int update(Ia ia);
	public int delete(int id);
	public Ia find(int id);
	public List<Ia> findAll();
}
