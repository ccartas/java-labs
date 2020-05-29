package ro.ase.java.tcp.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import ro.ase.java.tcp.models.Message;

public class TcpClientObject {
	public static void main(String[] args) {
		try
			
			 {
			Socket objectSocket = new Socket("127.0.0.1", 8999);
			Message message = new Message("John", "Hello Server");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(objectSocket.getOutputStream());
			ObjectInputStream objectInputStream = new ObjectInputStream(objectSocket.getInputStream());
			objectOutputStream.writeObject(message);
			System.out.println(((Message) objectInputStream.readObject()).getPayload());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
