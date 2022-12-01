package com.groupeisi.ms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.groupeisi.ms.entities.Teacher;
import com.groupeisi.ms.entities.Transfer;
import com.groupeisi.ms.entities.User;

public class ITransferImpl implements ITransfer {
	private DB db = new DB();
	private ResultSet rs;
	private int result;

	public int save(Transfer transfer) {
		String sql = "INSERT INTO transfer VALUES(NULL,?,?)";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, transfer.getArriveYear());
			db.getPstm().setInt(2, transfer.getLeavingYear());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int update(Transfer transfer) {
		String sql = "Update transfer SET id=?, arriveYear=?, leavingYear=? where id=?";
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, transfer.getId());
			db.getPstm().setInt(2, transfer.getArriveYear());
			db.getPstm().setInt(3, transfer.getLeavingYear());
			db.getPstm().setInt(4, transfer.getId());
			result = db.executeMaj();
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public int delete(int id) {
		String sql = "Delete from transfer where id=?";
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

	public Transfer find(int id) {
		String sql = "Select * from transfer where id=?";
		Transfer tr = new Transfer();
		try {
			db.initPrepar(sql);
			db.getPstm().setInt(1, id);
			rs = db.executeSelect();
			while(rs.next()) {
				tr.setId(rs.getInt(1));
				tr.setArriveYear(rs.getInt(2));
				tr.setLeavingYear(rs.getInt(3));
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tr;
	}

	public List<Transfer> findAll() {
		List<Transfer> lstTrans = new ArrayList<Transfer>();
		String sql = "Select * from transfer";
		try {
			db.initPrepar(sql);
			rs = db.executeSelect();
			while(rs.next()) {
				Transfer tr = new Transfer();
				tr.setId(rs.getInt(1));
				tr.setArriveYear(rs.getInt(2));
				tr.setLeavingYear(rs.getInt(3));
				lstTrans.add(tr);
			}
			db.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lstTrans;
	}

}
