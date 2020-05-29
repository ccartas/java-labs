package ro.ase.java;

import java.io.IOException;
import java.net.ServerSocket;

import ro.ase.java.models.UserData;

public class Application {
	public static void main(String[] args) {
		try (
				ServerSocket socket = new ServerSocket(8999);
				UserData userData = new UserData("admin", "secret_token");
			){
				System.out.println(userData.getAuthToken());
				System.out.println(userData.getUsername());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
