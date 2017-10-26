package echoserver;

import java.net.*;
import java.io.*;

public class EchoClient {
	public static void main(String [] args){
		
//		System.out.println("Enter in stuff, type 'Exit' to close.");
		try {
			//send to server
			int send;
			int inChar;
			
			String hostname = "BEBOP";
			Socket socket = new Socket (hostname, 6013);
			//output stream
			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			//input stream set up
			InputStreamReader reader = new InputStreamReader(socket.getInputStream());
			
			while((send = System.in.read()) != -1){
				//System.out.print((char) send);
				out.write(send);
				
				out.flush();
				
				inChar = reader.read();
				System.out.print((char) inChar);
			}
			System.out.println("");
			
			socket.close();
			
		} catch (IOException ioe) {
			System.out.println("You gave us an error, nerd.");
			System.out.println(ioe);
		}
	}
}