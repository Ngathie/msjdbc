package com.groupeisi.ms;

import com.groupeisi.ms.dao.DB;

public class Test {

	public static void main(String[] args) {
		DB db = new DB();
		db.openConnection();
		//Factory.dbConnect().openConnection();
	}

}
