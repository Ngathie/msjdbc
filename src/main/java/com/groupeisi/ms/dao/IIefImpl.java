package com.groupeisi.ms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.ms.entities.Ief;
import com.groupeisi.ms.entities.School;

public class IIefImpl implements IIef {
	private DB db = new DB();
	private ResultSet rs;
	private int result;
	public int save(Ief ief) {
		String sql = "INSERT INTO ief VALUES(NULL,?)";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, ief.getName());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int update(Ief ief) {
		String sql = "Update ief SET id=?, name=? where id=?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, ief.getId());
			db.getPstm().setString(2, ief.getName());
			db.getPstm().setInt(3, ief.getId());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int delete(int id) {
		String sql = "Delete from ief where id=?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public Ief find(int id) {
		String sql = "Select * from ief where id=?";
		Ief iiief = new Ief();
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			rs = db.executeSelect();
			while(rs.next()) {
				iiief.setId(rs.getInt(1));
				iiief.setName(rs.getString(2));
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return iiief;
	}

	public List<Ief> findAll() {
		List<Ief> lstIef = new ArrayList<Ief>();
		String sql = "Select * from ief";
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			while(rs.next()) {
				Ief iiief = new Ief();
				iiief.setId(rs.getInt(1));
				iiief.setName(rs.getString(2));
				lstIef.add(iiief);
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lstIef;
	}

}
