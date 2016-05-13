package ServerSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Util.Paket;

public class ServStreamL extends Thread{
	
		private Socket client;
		private Server server;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
	
		public ServStreamL(Server server, Socket s) throws IOException{
			this.client = s;
			this.server = server;
			this.ois = new ObjectInputStream(client.getInputStream());
			this.oos = new ObjectOutputStream(client.getOutputStream());
		}
		
		public void run(){
			try {
				while (!client.isClosed()) {
					Paket pac1r = (Paket) ois.readObject();
					checkPaket(pac1r);
				}
				client.close();
			} catch (Exception e) {
				System.out.println("Kan inte läsa");
			}
		}
		
		public void checkPaket(Paket pac){
			switch (pac.getType()){
			
			case "file":
				System.out.println("PAKET == FILE");
				server.receiveFile(pac.getDoc());
				break;
			case "quit":
				server.disconnUsr(client);
				break;
			case "chat":
				System.out.println("PAKET == CHAT");
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
