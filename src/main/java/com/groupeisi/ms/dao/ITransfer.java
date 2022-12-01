package com.groupeisi.ms.dao;

import java.util.List;

import com.groupeisi.ms.entities.Transfer;

public interface ITransfer {
	public int save(Transfer transfer);
	public int update(Transfer transfer);
	public int delete(int id);
	public Transfer find(int id);
	public List<Transfer> findAll();
}
