package ClientSide2;

import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import GUI.ClientGUI;
import Util.Paket;

public class ClientStreamL2 extends Thread{
	
		private Socket server;
		private ClientGUI cG;
	
		public ClientStreamL2(Socket s, ClientGUI cG){
			this.server = s;
			this.cG = cG;
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
					//System.out.println(pac.getDoc().getTitle() + ": " + new String(pac.getDoc().getContent(), "UTF-8"));
					cG.appendChat(pac.getDoc().getTitle() + ": " + new String(pac.getDoc().getContent(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {}
				break;
//			case "help":
//				try {
//					//System.out.println(pac.getDoc().getTitle());
//					//System.out.println(new String(pac.getDoc().getContent(), "UTF-8"));
//				} catch (UnsupportedEncodingException e) {}
//				break;
			default :
				;
				break;
			}
		}
}
