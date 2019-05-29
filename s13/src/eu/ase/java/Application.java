package eu.ase.java;

import java.sql.SQLException;

public class Application {
	public static void main(String[] args) {
		DatabaseConnection dbConn = new DatabaseConnection();
		try {
			dbConn.connect();
			dbConn.createTable();
			dbConn.insertRecord(2, "Iphone XR", 4000);
			dbConn.selectRecords();
			dbConn.updateRecord(1, 6000);
			dbConn.selectRecords();
			dbConn.deleteRecord(1);
			dbConn.selectRecords();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
