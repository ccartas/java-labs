package ro.ase.java.client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import ro.ase.java.models.Message;

public class UDPClientApplication {
	public static final int MAX_PACKET_LENGTH = 1000;
	public static final int SERVER_PORT = 8999;
	public static void main(String[] args) {
		try (
				DatagramSocket clientSocket = new DatagramSocket();	
			){
				byte[] buffer = new byte[MAX_PACKET_LENGTH];
				String payload = "Hello server";
				/*
				// prima varianta
				for(int i = 0; i < payload.length(); i++) {
					buffer[i] = (byte) payload.charAt(i);
				}
				*/
				/*
				buffer = payload.getBytes();
				InetAddress address = InetAddress.getByName("127.0.0.1");
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, SERVER_PORT);
				clientSocket.send(packet);
				
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
				dataOutputStream.writeDouble(2400);
				dataOutputStream.close();
				buffer = outputStream.toByteArray();
				packet = new DatagramPacket(buffer, buffer.length, address, SERVER_PORT);
				clientSocket.send(packet);
				*/
				InetAddress address = InetAddress.getByName("127.0.0.1");
				ByteArrayOutputStream objectByteArray = new ByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(objectByteArray);
				Message message = new Message("Cosmin", "Hello");
				objectOutputStream.writeObject(message);
				objectOutputStream.close(); // nu uitati sa inchideti stream-ul, altfel mesajele nu vor putea fi
											// deserializate pe partea de server
				buffer = objectByteArray.toByteArray();
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, SERVER_PORT);
				clientSocket.send(packet);
				
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
