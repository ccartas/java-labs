package eu.ase.java.tcp.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import eu.ase.java.models.Message;

public class TcpServerMultiThread implements Runnable{
	private static ServerSocket serverSocket;
	private Socket clientSocket;
	
	public TcpServerMultiThread(Socket socket) {
		this.clientSocket = socket;
	}
	
	public static ServerSocket getServerSocket(int port) throws IOException {
		if(serverSocket == null)
			serverSocket = new ServerSocket(port);
		System.out.println("Server started on port: "+port);
		return serverSocket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try (
				ObjectInputStream objectInputStream = 
				new ObjectInputStream(clientSocket.getInputStream());
		ObjectOutputStream objectOutputStream = 
				new ObjectOutputStream(clientSocket.getOutputStream());	
				) {
				Message m1 = (Message) objectInputStream.readObject();
				System.out.println(m1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
