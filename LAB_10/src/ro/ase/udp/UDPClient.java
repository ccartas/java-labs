package ro.ase.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        
        byte[] message = new String("Hello world!").getBytes();
        
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(message, message.length, address, 7788);
        clientSocket.send(packet);
        
        byte[] bufResponse = new byte[256];
        packet = new DatagramPacket(bufResponse, bufResponse.length);
        clientSocket.receive(packet);
        
        String received = new String(packet.getData());
        System.out.println("Messasge from server = " + received);
        
        clientSocket.close();
    }
}
