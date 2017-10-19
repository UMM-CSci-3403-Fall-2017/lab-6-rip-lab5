package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
	public static void main(String [] args) {
		try {
			ServerSocket socket = new ServerSocket(6013);
			
			while(true) {
				System.out.println("Get a request!");
				Socket client = socket.accept();
				
				PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
				
				writer.println()
			}
		}
	}
}