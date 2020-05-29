package ro.ase.java.tcp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerApplication {
	public static final int SERVER_PORT = 8999;
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = TcpServer.getServerSocket(SERVER_PORT);
			while(true) {
				Socket socket = serverSocket.accept();
				TcpServer threadSocket = new TcpServer(socket);
				Thread t = new Thread(threadSocket);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
