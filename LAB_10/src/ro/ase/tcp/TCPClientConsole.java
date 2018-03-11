package ro.ase.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClientConsole {

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
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput;

			while ((userInput = stdIn.readLine()) != null) {
			    out.println(userInput);
				String lin = in.readLine();
			    System.out.println("Sever: " + lin);
				if (lin.compareTo("exit") == 0) break;
			}

			out.close();
			in.close();
			stdIn.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
