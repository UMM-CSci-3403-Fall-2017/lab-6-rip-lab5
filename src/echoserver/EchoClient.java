package echoserver;

import java.net.*;
import java.io.*;

public class EchoClient {
	public static void main(String [] args){
		int inChar;
//		System.out.println("Enter in stuff, type 'Exit' to close.");
		try {
			//String hostname = args[0];
			//Socket socket = new Socket (hostname, 6013); 
			
			while((inChar = System.in.read()) != -1) {
				System.out.println(inChar);
			}
			
		} catch (IOException ioe) {
			System.out.println("You gave us an error, nerd.");
			System.out.println(ioe);
		}
	}
}