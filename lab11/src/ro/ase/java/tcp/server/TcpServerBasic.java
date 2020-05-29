package ro.ase.java.tcp.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import ro.ase.java.tcp.models.Message;

public class TcpServerBasic {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8999);
			System.out.println("Server started on port 8999...");
			Socket basicClientSocket = serverSocket.accept();
			System.out.println("Basic Client socket connected to server...");
			BufferedReader reader = new BufferedReader(new InputStreamReader(basicClientSocket.getInputStream()));
			System.out.println(reader.readLine());
			reader.close();
			basicClientSocket.close();
			
			Socket binaryClientSocket = serverSocket.accept();
			System.out.println("Data Client socket connected to server...");
			DataInputStream dataInputStream = new DataInputStream(binaryClientSocket.getInputStream());
			System.out.println(dataInputStream.readDouble());
			dataInputStream.close();
			binaryClientSocket.close();
			
			Socket objectClientSocket = serverSocket.accept();
			System.out.println("Object Client socket connected to server...");
			ObjectInputStream objectInputStream = new ObjectInputStream(objectClientSocket.getInputStream());
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(objectClientSocket.getOutputStream());
			Message message = (Message) objectInputStream.readObject();
			System.out.println(String.format("%s: %s", message.getSender(), message.getPayload()));
			objectOutputStream.writeObject(new Message("Server", "Hello "+message.getSender()));
			//objectInputStream.close();
			//objectOutputStream.close();
			//objectClientSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
