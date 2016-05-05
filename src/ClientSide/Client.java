package ClientSide;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import ServerSide.ServStreamL;

public class Client {
	
	public static void main(String[] args){
		try {
			Socket s = new Socket("127.0.0.1", 30000);
			
			System.out.println("SKRIV");
			
			Thread listener = new ClientStreamL(s);
			listener.start();
			
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter out = new PrintWriter(new BufferedOutputStream(s.getOutputStream()), true);
				while (!s.isClosed()) {
					String line = in.readLine();
					out.println(line);
				}
				s.close();
			} catch (Exception e) {
				System.out.println("Kan inte skriva");
			}			
			
			
		} catch (IOException e) {
			
		}
	}

}
