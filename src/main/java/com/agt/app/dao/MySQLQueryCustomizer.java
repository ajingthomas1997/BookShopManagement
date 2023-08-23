package com.agt.app.dao;

public class MySQLQueryCustomizer {

	public String prepareSelectQuery(String tableName, String[] columns, String condition) {

		String columnsStr;

		if (columns == null) {

			columnsStr = "*";

		} else {

			columnsStr = String.join(", ", columns);

		}

		String sqlQuery = "SELECT " + columnsStr + " FROM " + tableName;

		if (condition != null && !condition.isEmpty()) {

			sqlQuery += " WHERE " + condition;

		}

		System.out.println(sqlQuery);
		
		return sqlQuery;
		
	}
	
	public String prepareSelectQueryLimit(String tableName, String[] columns, String condition, int limit, int offset) {

		String columnsStr;

		if (columns == null) {

			columnsStr = "*";

		} else {

			columnsStr = String.join(", ", columns);

		}

		String sqlQuery = "SELECT " + columnsStr + " FROM " + tableName;

		if (condition != null && !condition.isEmpty()) {

			sqlQuery += " WHERE " + condition;

		}
		
		if (limit != 0) {
			
			sqlQuery += " limit "+limit;
			
			if(offset != 0) {
				
				sqlQuery += " offset "+offset;
				
			}
			
		}

		System.out.println(sqlQuery);
		
		return sqlQuery;

	}

	public String prepareInsertQuery(String tableName, String[] columns, String[] values) {

		if (columns.length != values.length) {

			throw new IllegalArgumentException("Number of columns and values must be the same.");

		}

		String columnsStr = String.join(", ", columns);

		String valuesStr = "'" + String.join("', '", values) + "'";

		String sqlQuery = "INSERT INTO " + tableName + " (" + columnsStr + ") VALUES (" + valuesStr + ")";

		System.out.println(sqlQuery);
		
		return sqlQuery;

	}

	public String prepareUpdateQuery(String tableName, String[] columns, String[] values, String condition) {

		if (columns.length != values.length) {

			throw new IllegalArgumentException("Number of columns and values must be the same.");

		}

		StringBuilder updateStr = new StringBuilder();

		for (int i = 0; i < columns.length; i++) {

			updateStr.append(columns[i]).append("='").append(values[i]).append("', ");

		}

		updateStr.deleteCharAt(updateStr.length() - 2); // Remove the last ', '

		String sqlQuery = "UPDATE " + tableName + " SET " + updateStr.toString();

		if (condition != null && !condition.isEmpty()) {

			sqlQuery += " WHERE " + condition;

		}

		System.out.println(sqlQuery);
		
		return sqlQuery;

	}

	public String prepareDeleteQuery(String tableName, String condition) {

		String sqlQuery = "DELETE FROM " + tableName;

		if (condition != null && !condition.isEmpty()) {

			sqlQuery += " WHERE " + condition;

		}

		System.out.println(sqlQuery);
		
		return sqlQuery;
	}

	

}
