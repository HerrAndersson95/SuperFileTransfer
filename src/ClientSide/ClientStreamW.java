package ClientSide;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import Util.Paket;

public class ClientStreamW extends Thread{
	
	private Socket client;
	
	public ClientStreamW(Socket s){
		this.client = s;
		
	}
	
	public void run(){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
			while (!client.isClosed()) {
				System.out.println("WAITING, What is the type?");
				String type = in.readLine();
				System.out.println("FIXED TO MSG, so what is message");
				String content = in.readLine();
				
				System.out.println("START SEND");
				Paket pak1 = new Paket(type, content.getBytes());
				oos.writeObject(pak1);
				System.out.println("END SEND");
				
			}
			client.close();
		} catch (Exception e) {
			System.out.println("Kan inte skriva");
		}
	}

}
