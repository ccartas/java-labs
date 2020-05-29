package ro.ase.java;

import java.sql.SQLException;

import ro.ase.java.utils.DatabaseAdapter;

public class Application {
	public static void main(String[] args) {
		DatabaseAdapter dbAdapter = new DatabaseAdapter();
		try {
			dbAdapter.connect();
			dbAdapter.createTables();
			dbAdapter.insertProduct("Iphone SE2", 2000);
			dbAdapter.insertProduct("Samsung S20 Ultra", 4500);
			dbAdapter.selectProducts(2000);
			dbAdapter.updateProduct(3, 5000);
			dbAdapter.deleteProduct(4);
			dbAdapter.selectProducts(2000);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbAdapter.disconnect();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
