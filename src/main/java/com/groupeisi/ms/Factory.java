package com.groupeisi.ms;

import com.groupeisi.ms.dao.DB;

public class Factory {
	public static DB dbConnect() {
		return new DB();
	}
}
