package eu.ase.java.tcp.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpClientData {
	public static void main(String[] args) {
		try (Socket clientSocketData = new Socket("127.0.0.1", 8999)) {
			DataOutputStream dos = new DataOutputStream(clientSocketData.getOutputStream());
			dos.writeUTF("UTF String");
		} catch (IOException ex) {
			
		}
	}
}
