package ClientSide;

import java.net.Socket;

public class Client {
	
	public static void main(String[] args){
		try {
			
			Socket s = new Socket(args[0], Integer.parseInt(args[1]));
			
			System.out.println("Connected to Server");
			
			Thread listener = new ClientStreamL(s);
			listener.start();
			Thread Writer = new ClientStreamW(s);
			Writer.start();
			
		} catch (Exception e) {
			System.out.println("--ERROR CONN NOT EST--");
			e.printStackTrace();
		}
	}

}
