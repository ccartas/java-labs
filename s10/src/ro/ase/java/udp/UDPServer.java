package ro.ase.java.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	public static final int MAX_PACKET_LENGTH = 1000;
	
	public static void main(String[] args) {
		byte[] bufferForReceivedPackages = null;
		byte[] bufferForSentPackages = null;
		
		try (DatagramSocket socket = new DatagramSocket(8899)) {
			System.out.println("Server started on port 8899...");
			while(true) {
				bufferForReceivedPackages = new byte[MAX_PACKET_LENGTH];
				DatagramPacket packet = new DatagramPacket(bufferForReceivedPackages, bufferForReceivedPackages.length);
				socket.receive(packet);
				System.out.println(new String(packet.getData()));
				
				bufferForSentPackages = new byte[MAX_PACKET_LENGTH];
				String responseMessage = new String("GOT IT");
				bufferForReceivedPackages = responseMessage.getBytes();
				InetAddress addr = packet.getAddress();
				int port = packet.getPort();
				System.out.println("Port no: "+port);
				DatagramPacket packetResponse = new DatagramPacket(bufferForReceivedPackages, bufferForReceivedPackages.length, addr, port);
				socket.send(packetResponse);
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
