package ro.ase.java.udp.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GroupChatServer {
	public static final int MAX_PACKET_LENGTH = 1000;
	
	public static final void main(String[] args) {
		boolean running = true;
		byte[] buffer = null;
		try (DatagramSocket socket = new DatagramSocket(8899)){
			while(running) {
				buffer = new String("Hello").getBytes();
				InetAddress group = InetAddress.getByName("230.0.0.1");
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 8898);
				socket.send(packet);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
