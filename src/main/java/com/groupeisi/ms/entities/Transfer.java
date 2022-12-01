package com.groupeisi.ms.entities;

public class Transfer {
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArriveYear() {
		return arriveYear;
	}
	public void setArriveYear(int arriveYear) {
		this.arriveYear = arriveYear;
	}
	public int getLeavingYear() {
		return leavingYear;
	}
	public void setLeavingYear(int leavingYear) {
		this.leavingYear = leavingYear;
	}
	private int arriveYear;
	private int leavingYear;
}
