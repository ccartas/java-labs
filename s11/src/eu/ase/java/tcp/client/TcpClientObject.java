package eu.ase.java.tcp.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import models.Message;

public class TcpClientObject {
	public static void main(String[] args) {
		try(Socket objectSocket = new Socket("127.0.0.1", 8999)) {
			Message m = new Message("John", "Hello sir.");
			ObjectOutputStream ous = new ObjectOutputStream(objectSocket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(objectSocket.getInputStream());
			ous.writeObject(m);
			try {
				System.out.println(((Message)ois.readObject()).getPayload());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(IOException ex) {
			
		}
	}
}
