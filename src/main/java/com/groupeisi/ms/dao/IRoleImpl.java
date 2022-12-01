package com.groupeisi.ms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.ms.entities.Role;
import com.groupeisi.ms.entities.School;

public class IRoleImpl implements IRole {
	private DB db = new DB();
	private ResultSet rs;
	private int result;

	public int save(Role role) {
		String sql = "INSERT INTO role VALUES(NULL,?)";
		try {
			db.initPrepar(sql);
			db.getPstm().setString(1, role.getName());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int update(Role role) {
		String sql = "Update role SET id=?, name=? where id=?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, role.getId());
			db.getPstm().setString(2, role.getName());
			db.getPstm().setInt(3, role.getId());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int delete(int id) {
		String sql = "Delete from role where id=?";
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

	public Role find(int id) {
		String sql = "Select * from role where id=?";
		Role rl = new Role();
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			rs = db.executeSelect();
			while(rs.next()) {
				rl.setId(rs.getInt(1));
				rl.setName(rs.getString(2));
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rl;
	}

	public List<Role> findAll() {
		List<Role> lstRole = new ArrayList<Role>();
		String sql = "Select * from role";
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			while(rs.next()) {
				Role rl = new Role();
				rl.setId(rs.getInt(1));
				rl.setName(rs.getString(2));
				lstRole.add(rl);
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lstRole;
	}

}
