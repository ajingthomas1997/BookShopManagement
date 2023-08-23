package com.agt.app.reclyclebin;

public class QueryCustomizer {

	// while selecting table, you can consider 1,2,3,4,.. order..
	public String[] tables = { "Admins", "Users", "Books", "Orders" };
	
	public String selectStatement(String tableColumns, int tableNumber, String condition) {

		if (condition == null) {

			condition = "";

		} else {

			condition = " where " + condition;

		}

		return "SELECT " + tableColumns + " FROM " + tables[tableNumber - 1] + condition;

	}

	public String insertStatement(int tableNumber, String tableColumns, String tableValues) {

		return "INSERT INTO " + tables[tableNumber - 1] + " (" + tableColumns + ") VALUES (" + tableValues + ")";

	}

	public String updateStatement(int tableNumber, String tableColumnsAndValues, String condition) {

		return "UPDATE " + tables[tableNumber - 1] + " SET " + tableColumnsAndValues + " WHERE " + condition;

	}

	public String deleteStatement(int tableNumber, String condition) {

		return "DELETE FROM " + tables[tableNumber - 1] + " WHERE " + condition;

	}
	
}
