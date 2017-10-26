package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
	public static void main(String [] args) {
		try {
			int send;
			
			ServerSocket socket = new ServerSocket(6013);
			
			while(true) {
				System.out.println("Get a request!");
				Socket client = socket.accept();
				
				//output stream
				OutputStream out = client.getOutputStream();
				
				//input stream
				InputStream reader = client.getInputStream();
				
				/*
				 * Reads and writes back a byte from the client, while there
				 * is still bytes to be read
				 */
				while((send = reader.read()) != -1){
					out.write(send);
				}
				
				out.flush();
				client.close();
			}
		} catch (IOException ioe) {
			System.out.println("There has been an error:");
			System.out.println(ioe);
		}
	}
}