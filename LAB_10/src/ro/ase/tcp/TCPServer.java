package ro.ase.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// keeps order
// big packages
// require pre-connection
// use-case: web
public class TCPServer {
	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket clientSocket = null;

		boolean listening = true;

		OutputStream os = null;
		PrintWriter out = null;
		InputStream is = null;
		BufferedReader in = null;
		String inputLine = null, outputLine = null;

		try {
			serverSocket = new ServerSocket(4801);
			System.out.println("Server started on port 4801");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		while (listening) {
			try {
				clientSocket = serverSocket.accept();

				is = clientSocket.getInputStream();
				in = new BufferedReader(new InputStreamReader(is));

				os = clientSocket.getOutputStream();
				out = new PrintWriter(os, true);

				while ((inputLine = in.readLine()) != null) {
					System.out.println(inputLine);
					outputLine = new String("OK");
					out.println(outputLine);
					out.flush();

					if (inputLine.compareTo("exit") == 0) {
						break;
					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				try {
					if (out != null)
						out.close();
					if (in != null)
						in.close();
					if (clientSocket != null)
						clientSocket.close();
				} catch (IOException ioec) {
					ioec.printStackTrace();
				}
			}
		}
		try {
			serverSocket.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
