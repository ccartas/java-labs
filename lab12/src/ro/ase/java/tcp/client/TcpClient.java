package ro.ase.java.tcp.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import ro.ase.java.tcp.models.Message;

public class TcpClient {
	private String host;
	private int serverPort;
	private Socket clientSocket;
	
	public TcpClient(String host, int port) {
		this.host = host;
		this.serverPort = port;
	}
	
	public void connect() throws UnknownHostException, IOException {
		this.clientSocket = new Socket(this.host, this.serverPort);
	}
	
	public void send(Message message) {
		try (
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.clientSocket.getOutputStream());
			){
				objectOutputStream.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
