package ro.ase.java.udp.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class GroupChatClient {
	public static final int MAX_PACKET_LEGNTH = 1000;
	public static void main(String[] args) {
		try {
			MulticastSocket socket = new MulticastSocket(8898);
			InetAddress group = InetAddress.getByName("230.0.0.1");
			socket.joinGroup(group);
			
			DatagramPacket packet;
			
			for(int i = 0; i < 5;i++) {
				byte[] buff = new byte[MAX_PACKET_LEGNTH];
				packet = new DatagramPacket(buff, buff.length);
				socket.receive(packet);
				System.out.println(new String(packet.getData()));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
