package ro.ase.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) {

		Socket clientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			clientSocket = new Socket("127.0.0.1", 4801);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			String lin = "";
			out.println("I would like to connect!");
			lin = in.readLine();
			System.out.println("Sever: " + lin);

			out.println("What date is it?");
			lin = in.readLine();
			System.out.println("Sever: " + lin);

			out.println("What time is it?");
			lin = in.readLine();
			System.out.println("Server: " + lin);

			out.println("exit");
			lin = in.readLine();
			System.out.println("Sever: " + lin);

			out.close();
			in.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
