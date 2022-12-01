package com.groupeisi.ms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.ms.entities.Ia;
import com.groupeisi.ms.entities.Ief;

public class IIaImpl implements IIa {
	private DB db = new DB();
	private ResultSet rs;
	private int result;

	public int save(Ia ia) {
		String sql = "INSERT INTO ia VALUES(NULL,?)";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, ia.getName());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int update(Ia ia) {
		String sql = "Update ia SET id=?, name=? where id=?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, ia.getId());
			db.getPstm().setString(2, ia.getName());
			db.getPstm().setInt(3, ia.getId());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int delete(int id) {
		String sql = "Delete from ia where id=?";
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

	public Ia find(int id) {
		String sql = "Select * from ia where id=?";
		Ia iiia = new Ia();
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			rs = db.executeSelect();
			while(rs.next()) {
				iiia.setId(rs.getInt(1));
				iiia.setName(rs.getString(2));
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return iiia;
	}

	public List<Ia> findAll() {
		List<Ia> lstIa = new ArrayList<Ia>();
		String sql = "Select * from ia";
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			while(rs.next()) {
				Ia iia = new Ia();
				iia.setId(rs.getInt(1));
				iia.setName(rs.getString(2));
				lstIa.add(iia);
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lstIa;
	}

}
