package com.groupeisi.ms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.ms.entities.Teacher;
import com.groupeisi.ms.entities.User;

public class ITeacherImpl implements ITeacher {
	private DB db = new DB();
	private ResultSet rs;
	private int result;

	public int save(Teacher teacher) {
		String sql = "INSERT INTO teacher VALUES(NULL,?,?,?)";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, teacher.getFirstName());
			db.getPstm().setString(2, teacher.getLastName());
			db.getPstm().setString(3, teacher.getPhoneNumber());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int update(Teacher teacher) {
		String sql = "Update teacher SET id=?, firstName=?, lastName=?, phoneNumber=? where id=?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, teacher.getId());
			db.getPstm().setString(2, teacher.getFirstName());
			db.getPstm().setString(3, teacher.getLastName());
			db.getPstm().setString(4, teacher.getPhoneNumber());
			db.getPstm().setInt(5, teacher.getId());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int delete(int id) {
		String sql = "Delete from teacher where id=?";
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

	public Teacher find(int id) {
		String sql = "Select * from teacher where id=?";
		Teacher teach = new Teacher();
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			rs = db.executeSelect();
			while(rs.next()) {
				teach.setId(rs.getInt(1));
				teach.setFirstName(rs.getString(2));
				teach.setLastName(rs.getString(3));
				teach.setPhoneNumber(rs.getString(4));
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return teach;
	}

	public List<Teacher> findAll() {
		List<Teacher> lstTeach = new ArrayList<Teacher>();
		String sql = "Select * from user";
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			while(rs.next()) {
				Teacher teach = new Teacher();
				teach.setId(rs.getInt(1));
				teach.setFirstName(rs.getString(2));
				teach.setLastName(rs.getString(3));
				teach.setPhoneNumber(rs.getString(4));
				lstTeach.add(teach);
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lstTeach;
	}

}
