package ClientSide;

import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import Util.Paket;

public class ClientStreamL extends Thread{
	
		private Socket server;
	
		public ClientStreamL(Socket s){
			this.server = s;
		}
		
		public void run(){
			try {
				ObjectInputStream ois = new ObjectInputStream(server.getInputStream());
				while (!server.isClosed()) {
					Paket pac1r = (Paket) ois.readObject();
					checkPaket(pac1r);
				}
				server.close();
			} catch (Exception e) {
				System.out.println("Kan inte läsa");
				e.printStackTrace();
			}
		}
		
		public void checkPaket(Paket pac){
			switch (pac.getType()){
//			case "users" : 
//				server.getConnected(client);
//				break;
//			case "file":
//				server.receiveFile(pac.getDoc().getContent());
//				break;
			case "chat":
				try {
					System.out.println(pac.getDoc().getTitle() + ": " + new String(pac.getDoc().getContent(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {}
				break;
			case "help":
				try {
					System.out.println(pac.getDoc().getTitle());
					System.out.println(new String(pac.getDoc().getContent(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {}
				break;
			default :
				;
				break;
			}
		}
}
