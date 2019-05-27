package eu.ase.java.tcp.client;

import eu.ase.java.models.Message;

public class TcpClientApplication {
	public static void main(String[] args) {
		TcpClient client = new TcpClient("127.0.0.1", 8899);
		client.start();
		Message m1 = new Message("John", "Hello");
		client.send(m1);
	}
}
