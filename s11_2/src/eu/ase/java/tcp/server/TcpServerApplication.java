package eu.ase.java.tcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerApplication {
	public static void main(String[] args) {
		boolean isRunning = true;
		
		try {
			ServerSocket serverSocket = TcpServerMultiThread.getServerSocket(8899);
			while(isRunning) {
				Socket clientSocket = serverSocket.accept();
				TcpServerMultiThread threadSocket = 
						new TcpServerMultiThread(clientSocket);
				Thread t = new Thread(threadSocket);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
