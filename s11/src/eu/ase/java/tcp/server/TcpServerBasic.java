package eu.ase.java.tcp.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import models.Message;

public class TcpServerBasic {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8999);
			
			//Basic messaging
			Socket clientSocket = serverSocket.accept();
			BufferedReader received = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			System.out.println(received.readLine());
			received.close();
			clientSocket.close();
			
			//Data
			clientSocket = serverSocket.accept();
			DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
			System.out.println(dis.readUTF());
			dis.close();
			clientSocket.close();
			
			//Objects
			
			clientSocket = serverSocket.accept();
			ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
			try {
				System.out.println(((Message)ois.readObject()).getSender());
				oos.writeObject(new Message("Server", "Hellooo"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
