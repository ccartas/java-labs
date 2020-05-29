package ro.ase.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAdapter {
	private Connection dbConnection;
	private static final String DB_CONNECTION_URL = "jdbc:sqlite:products.db";
	private static final String CREATE_TABLE_PRODUCTS_STRING = "CREATE TABLE PRODUCTS" +
															"(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
															"PRODUCT_NAME TEXT NOT NULL,"+
															"PRODUCT_PRICE REAL NOT NULL)";
	
	private static final String DROP_TABLE_PRODUCTS_STRING = "DROP TABLE IF EXISTS PRODUCTS";
	
	
	public void connect() throws SQLException {
		this.dbConnection = DriverManager.getConnection(DB_CONNECTION_URL);
	}
	
	public void disconnect() throws SQLException {
		this.dbConnection.close();
	}
	
	public void createTables() throws SQLException {
		Statement statement = this.dbConnection.createStatement();
		statement.execute(DROP_TABLE_PRODUCTS_STRING);
		statement.execute(CREATE_TABLE_PRODUCTS_STRING);
		statement.close();
	}
	
	public void insertProduct(String productName, float productPrice) throws SQLException {
		Statement statement = this.dbConnection.createStatement();
		String INSERT_PRODUCT_QUERY = "INSERT INTO PRODUCTS (PRODUCT_NAME, PRODUCT_PRICE) values ('" + productName 
										+ "'," + productPrice + ")";
		statement.executeUpdate(INSERT_PRODUCT_QUERY);
		statement.close();
		
		String PS_QUERY = "INSERT INTO PRODUCTS (PRODUCT_NAME, PRODUCT_PRICE) VALUES (?, ?)";
		PreparedStatement preparedStatement = this.dbConnection.prepareStatement(PS_QUERY);
		preparedStatement.setString(1, productName);
		preparedStatement.setFloat(2, productPrice);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	public void selectProducts(float priceCriteria) throws SQLException {
		String PS_QUERY = "SELECT * FROM PRODUCTS WHERE PRODUCT_PRICE > ?";
		PreparedStatement preparedStatement = this.dbConnection.prepareStatement(PS_QUERY);
		preparedStatement.setFloat(1, priceCriteria);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		// pentru extragerea campurilor din iterator pot folosi atat numele coloanelor (nu sunt case sensitive), cat si indexul acestora
		// ATENTIE: Numarul coloanelor din SQL incepe numerotarea de la 1
		while(rs.next()) {
			System.out.println(String.format("ProductID: %d ProductName: %s ProductPrice: %f", 
					rs.getInt("id"),
					rs.getString("product_name"),
					rs.getFloat(3)));	
		}
		rs.close();
		preparedStatement.close();
	}
	
	public void updateProduct(int id, float newPrice) throws SQLException {
		String PS_QUERY = "UPDATE PRODUCTS SET PRODUCT_PRICE=? WHERE ID=?";
		PreparedStatement preparedStatement = this.dbConnection.prepareStatement(PS_QUERY);
		preparedStatement.setInt(2, id);
		preparedStatement.setFloat(1, newPrice);
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
	}
	
	public void deleteProduct(int id) throws SQLException {
		String PS_QUERY = "DELETE FROM PRODUCTS WHERE ID=?";
		PreparedStatement preparedStatement = this.dbConnection.prepareStatement(PS_QUERY);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
}
