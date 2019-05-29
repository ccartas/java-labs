package eu.ase.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	
	private static final String DB_CONNECTION_URL = "jdbc:sqlite:java.db";
	public static final String CREATE_TABLE_STRING = "CREATE TABLE PRODUCT"+
												"(ID INT PRIMARY KEY NOT NULL,"+
												"PRODUCT_NAME TEXT NOT NULL,"
												+ "PRODUCT_PRICE REAL NOT NULL)";
	public static final String DROP_TABLE_STRING = "DROP TABLE IF EXISTS PRODUCT";
	private Connection dbConnection;
	
	
	public void connect() throws SQLException {
			this.dbConnection = DriverManager.getConnection(DB_CONNECTION_URL);
	}
	
	public void disconnect() throws SQLException {
		this.dbConnection.close();
	}
	
	public void createTable() throws SQLException {
		Statement statement = this.dbConnection.createStatement();
		statement.execute(DROP_TABLE_STRING);
		statement.execute(CREATE_TABLE_STRING);
		statement.close();
	}
	
	public void insertRecord(int id, String name, float price) throws SQLException {
		Statement statement = this.dbConnection.createStatement();
		String CLASSIC_INSERT = "INSERT INTO PRODUCT (ID,PRODUCT_NAME,PRODUCT_PRICE) values "+
								"(1, 'Iphone XS', 5000)";
		statement.executeUpdate(CLASSIC_INSERT);
		statement.close();
		
		PreparedStatement ps = this.dbConnection.prepareStatement("INSERT INTO PRODUCT(ID, PRODUCT_NAME, PRODUCT_PRICE)"+
																"VALUES (?,?,?)");
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setFloat(3, price);
		ps.executeUpdate();
		
		ps.close();
	}
	
	public void selectRecords() throws SQLException {
		Statement stmt = this.dbConnection.createStatement();
		String SELECT_QUERY = "SELECT * from PRODUCT where PRODUCT_PRICE > 2000;";
		
		
		ResultSet rs = stmt.executeQuery(SELECT_QUERY);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("product_name");
			float price = rs.getFloat("product_price");
			System.out.println(id + " " + name + " " + price);
		}
		
		rs.close();
		stmt.close();
	}
	
	
	public void updateRecord(int id, float newPrice) throws SQLException {
		PreparedStatement ps = this.dbConnection.prepareStatement("UPDATE PRODUCT SET PRODUCT_PRICE=? WHERE ID=?");
		ps.setFloat(1, newPrice);
		ps.setInt(2, id);
		ps.executeUpdate();
		ps.close();
	}
	
	public void deleteRecord(int id) throws SQLException {
		PreparedStatement ps = this.dbConnection.prepareStatement("DELETE FROM PRODUCT WHERE ID=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}
}
