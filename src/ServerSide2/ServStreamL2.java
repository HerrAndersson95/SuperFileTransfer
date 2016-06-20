package ServerSide2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import GUI.ServerGUI;
import Util.Paket;

public class ServStreamL2 extends Thread{
	
		private Socket client;
		private Server2 server;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		private ServerGUI sG;
	
		public ServStreamL2(Server2 server, Socket s, ServerGUI sG) throws IOException{
			this.client = s;
			this.server = server;
			this.ois = new ObjectInputStream(client.getInputStream());
			this.oos = new ObjectOutputStream(client.getOutputStream());
			this.sG = sG;
		}
		
		public void run(){
			try {
				while (!client.isClosed()) {
					Paket pac1r = (Paket) ois.readObject();
					checkPaket(pac1r);
				}
				client.close();
			} catch (Exception e) {
				sG.appendChat("Someone might have disconnected. Or error...");
			}
		}
		
		public void checkPaket(Paket pac){
			switch (pac.getType()){
			
			case "file":
				sG.appendChat("PAKET == FILE");
				server.receiveFile(pac.getDoc());
				break;
			case "quit":
				server.disconnUsr(client);
				break;
			case "chat":
				sG.appendChat("PAKET == CHAT");
				try {
					sG.appendChat(pac.getDoc().getTitle() + ": " + new String(pac.getDoc().getContent(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {}
				
				server.sendChat(pac);
				break;
			case "help":
				server.getCommands();
				break;
			default :
				;
				break;
			}
			
		}
		
		public void sendToClients(Paket pac){
			try {
				oos.writeObject(pac);
			} catch (IOException e) {}
		}
}
