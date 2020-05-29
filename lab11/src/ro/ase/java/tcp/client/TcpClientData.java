package ro.ase.java.tcp.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientData {
	public static void main(String[] args) {
		//Try with resources
		try (
				Socket clientSocketData = new Socket("127.0.0.1", 8999);
			){
			DataOutputStream dataOutputStream = new DataOutputStream(clientSocketData.getOutputStream());
			dataOutputStream.writeDouble(2500);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
