package com.groupeisi.ms.dao;

import java.util.List;

import com.groupeisi.ms.entities.Ief;

public interface IIef {
	public int save(Ief ief);
	public int update(Ief ief);
	public int delete(int id);
	public Ief find(int id);
	public List<Ief> findAll();
}
