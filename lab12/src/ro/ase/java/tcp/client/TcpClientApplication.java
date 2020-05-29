package ro.ase.java.tcp.client;

import java.io.IOException;
import java.net.UnknownHostException;

import ro.ase.java.tcp.models.Message;

public class TcpClientApplication {
	public static final String SERVER_HOST = "127.0.0.1";
	public static final int SERVER_PORT = 8999;
	public static void main(String[] args) {
		
		TcpClient client = new TcpClient(SERVER_HOST, SERVER_PORT);
		try {
			client.connect();
			Message m1 = new Message("John", "Hello everyone");
			client.send(m1);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
