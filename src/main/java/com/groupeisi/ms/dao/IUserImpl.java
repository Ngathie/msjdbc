package com.groupeisi.ms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.ms.entities.User;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class IUserImpl implements IUser {
	private DB db = new DB();
	private ResultSet rs;
	private int result;
	

	public int save(User user) {
		String sql = "INSERT INTO user VALUES(NULL,?,?,?,?)";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, user.getFirstName());
			db.getPstm().setString(2, user.getLastName());
			db.getPstm().setString(3, user.getEmail());
			db.getPstm().setString(4, user.getPassword());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return result;
	}

	public int update(User user) {
		String sql = "Update user SET firstName=?, lastName=?, email=?, passWord=? where id=?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, user.getId());
			db.getPstm().setString(2, user.getFirstName());
			db.getPstm().setString(3, user.getLastName());
			db.getPstm().setString(4, user.getEmail());
			db.getPstm().setString(5, user.getPassword());
			db.getPstm().setInt(6, user.getId());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int delete(int id) {
		String sql = "Delete * from user where id=?";
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

	public User find(int id) {
		String sql = "Select * from user where id=?";
		User u = new User();
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			rs = db.executeSelect();
			if(rs.next()) {
				u.setId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return u;
	}

	public List<User> findAll() {
		List<User> lstUtilisateurs = new ArrayList<User>();
		String sql = "Select * from user";
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				lstUtilisateurs.add(u);
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lstUtilisateurs;
	}

}
