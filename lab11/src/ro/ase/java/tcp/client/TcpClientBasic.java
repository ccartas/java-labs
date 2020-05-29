package ro.ase.java.tcp.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientBasic {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("127.0.0.1", 8999);
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
			writer.println(new String("Hello from the client side"));
			clientSocket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
