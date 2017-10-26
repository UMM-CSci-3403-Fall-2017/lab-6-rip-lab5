package echoserver;

import java.net.*;
import java.io.*;

public class EchoClient {
	public static void main(String [] args){
		try {
			int send;
			int inChar;
			
			String hostname = "localhost";
			Socket socket = new Socket (hostname, 6013);
			
			//output stream
			OutputStream out = socket.getOutputStream();
			
			//input stream set up
			InputStream reader = socket.getInputStream();
			
			/*
			 * Runs while there is still bytes to be read
			 * Writes the given byte, then receives it back from the server and writes to standard out
			 */
			while((send = System.in.read()) != -1){
				out.write(send);
				inChar = reader.read();
				System.out.write((char) inChar);
			}
			
			out.flush();
			System.out.flush();
			socket.close();
			
		} catch (IOException ioe) {
			System.out.println("There has been an error: ");
			System.out.println(ioe);
		}
	}
}