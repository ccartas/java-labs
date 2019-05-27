package eu.ase.java.tcp.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import eu.ase.java.models.Message;

public class TcpClient {
	private String host;
	private int serverPort;
	private Socket clientSocket;
	
	public TcpClient(String host, int serverPort) {
		this.host = host;
		this.serverPort = serverPort;
	}
	
	public void start() {
		try{
			this.clientSocket = new Socket(this.host, this.serverPort);
		} catch(IOException ex) {
			
		}
	}
	
	public void send(Message message) {
		try (ObjectOutputStream objectOutputStream = 
					new ObjectOutputStream(this.clientSocket.getOutputStream());
			 ObjectInputStream objectInputStream = 
					 new ObjectInputStream(this.clientSocket.getInputStream());
			){
			objectOutputStream.writeObject(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
