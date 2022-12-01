package com.groupeisi.ms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.ms.entities.School;
import com.groupeisi.ms.entities.User;

public class ISchoolImpl implements ISchool {
	private DB db = new DB();
	private ResultSet rs;
	private int result;

	public int save(School school) {
		String sql = "INSERT INTO school VALUES(NULL,?)";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, school.getName());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int update(School school) {
		String sql = "Update school SET id=?, name=? where id=?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, school.getId());
			db.getPstm().setString(2, school.getName());
			db.getPstm().setInt(3, school.getId());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int delete(int id) {
		String sql = "Delete from school where id=?";
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

	public School find(int id) {
		String sql = "Select * from school where id=?";
		School sc = new School();
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			rs = db.executeSelect();
			while(rs.next()) {
				sc.setId(rs.getInt(1));
				sc.setName(rs.getString(2));
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sc;
	}

	public List<School> findAll() {
		List<School> lstEcole = new ArrayList<School>();
		String sql = "Select * from school";
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			while(rs.next()) {
				School sc = new School();
				sc.setId(rs.getInt(1));
				sc.setName(rs.getString(2));
				lstEcole.add(sc);
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lstEcole;
	}

}
