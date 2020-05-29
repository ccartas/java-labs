package ro.ase.java.server;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import ro.ase.java.models.Message;

public class UDPServerApplication {
	public static final int SERVER_PORT = 8999;
	public static final int MAX_PACKET_LENGTH = 1000;
	public static void main(String[] args) {
		try (
				DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);
			){
				while(true) {
				byte[] bufferForReceivedPackages = new byte[MAX_PACKET_LENGTH];
				/*
				System.out.println(String.format("UDP Server started on port %d", SERVER_PORT));
				DatagramPacket packet = new DatagramPacket(bufferForReceivedPackages, MAX_PACKET_LENGTH);
				serverSocket.receive(packet);
				System.out.println(new String(packet.getData()));
				
				// Primire de pachete folosind DataInputStream
				packet = new DatagramPacket(bufferForReceivedPackages, MAX_PACKET_LENGTH);
				
				serverSocket.receive(packet);
				DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(packet.getData()));
				System.out.println(String.format("Double from client %f",dataInputStream.readDouble()));
				*/
				
				// Primire de pachete folosind serializarea de obiecte in retea
				DatagramPacket packet = new DatagramPacket(bufferForReceivedPackages, MAX_PACKET_LENGTH);
				serverSocket.receive(packet);
				ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(packet.getData()));
				System.out.println((Message) objectInputStream.readObject());
				}
				
				
		} catch (SocketException e) {
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
