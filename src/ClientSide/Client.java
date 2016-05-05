package ClientSide;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args){
		try {
			Socket s = new Socket(InetAddress.getLocalHost(), 30000);
			
			System.out.println("SKRIV");
			
			Thread listener = new ClientStreamL(s);
			listener.start();
			Thread Writer = new ClientStreamW(s);
			Writer.start();
			
		} catch (IOException e) {
			
		}
	}

}
