package ro.ase.java.tcp.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ro.ase.java.tcp.models.Message;

public class TcpServer implements Runnable {
	private static ServerSocket serverSocket;
	private Socket clientSocket;
	
	public TcpServer(Socket client) {
		this.clientSocket = client;
	}
	
	public static ServerSocket getServerSocket(int port) throws IOException {
		if(serverSocket == null) {
			serverSocket = new ServerSocket(port);
			System.out.println(String.format("Server started on port %d", port));
		}
		return serverSocket;
	}

	@Override
	public void run() {
		try (
				ObjectInputStream objectInputStream = new ObjectInputStream(this.clientSocket.getInputStream());
			){
				Message message = (Message) objectInputStream.readObject();
				System.out.println(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
