package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
	public static void main(String [] args) {
		try {
			//send to server
			int send;
			int inChar;
			
			ServerSocket socket = new ServerSocket(6013);
			
			while(true) {
				System.out.println("Get a request!");
				Socket client = socket.accept();
				
				//output stream
				OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
				//input stream
				InputStreamReader reader = new InputStreamReader(client.getInputStream());
				
				send = reader.read();
				out.write(send);
				client.close();
			}
		} catch (IOException ioe) {
			System.out.println("You gave us an error, nerd.");
			System.out.println(ioe);
		}
	}
}