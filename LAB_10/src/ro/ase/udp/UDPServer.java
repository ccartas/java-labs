package ro.ase.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// small packages 
// no pre-connection needed
// dosen't keep an order
// faster then TCP but not that reliable
// use-case: video streams
public class UDPServer {
	
	private final static int PORT = 7788;

	public static void main(String[] args) {
		DatagramSocket socket = null;
		byte[] bufferResponse = null;
		byte[] bufferReceive = null;

		try {
			socket = new DatagramSocket(PORT);
			System.out.println("Server started on port " + PORT);

			while (true) {
				bufferReceive = new byte[256];

				DatagramPacket packet = new DatagramPacket(bufferReceive, bufferReceive.length);
				socket.receive(packet);

				System.out.println("Message from client: " + new String(bufferReceive));

				String respString = new String("OK");
				bufferResponse = respString.getBytes();

				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				packet = new DatagramPacket(bufferResponse, bufferResponse.length, address, port);
				socket.send(packet);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
