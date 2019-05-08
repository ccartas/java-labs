package ro.ase.java.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
	
	public static final int MAX_LENGTH = 1000;
	
	public static void main(String[] args) {
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			// send the request
			byte[] buf = new byte[MAX_LENGTH];
			String message = "Hello server";
			for(int i = 0;i < message.length();i ++) {
				buf[i] = (byte) message.charAt(i);
			}
			InetAddress address = InetAddress.getByName("127.0.0.1");
			DatagramPacket packet = 
					new DatagramPacket(buf, buf.length, address, 8899);
			clientSocket.send(packet);
			
			byte[] bufferForResponse = new byte[MAX_LENGTH];
			packet = new DatagramPacket(bufferForResponse, bufferForResponse.length);
			clientSocket.receive(packet);
			
			String receivedMessage = new String(bufferForResponse);
			System.out.println(receivedMessage);

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
