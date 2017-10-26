package echoserver;

import java.net.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class EchoServer {
	public static void main(String [] args) {
		try {
			//send to server
			int send;
			int bytesReceived=0;
			
			ServerSocket socket = new ServerSocket(6013);
			
			while(true) {
				System.out.println("Get a request!");
				Socket client = socket.accept();
				
				//output stream
//				OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
				OutputStream out = client.getOutputStream();
				
				//input stream
				//InputStreamReader reader = new InputStreamReader(client.getInputStream());
				InputStream reader = client.getInputStream();
				
				while((send = reader.read()) != -1){
					bytesReceived++;
					//System.out.print((char) send);
					
					out.write(send);
					
//					try {
//						Thread.sleep(1);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
				}
				out.flush();
				client.close();
				
				System.out.printf("Receive %d bytes",bytesReceived);
			}
		} catch (IOException ioe) {
			System.out.println("You gave us an error, nerd.");
			System.out.println(ioe);
		}
	}
}