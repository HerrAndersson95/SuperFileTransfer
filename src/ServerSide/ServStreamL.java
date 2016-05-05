package ServerSide;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServStreamL extends Thread{
	
		private Socket client;
		private Server server;
	
		public ServStreamL(Server server, Socket s){
			this.client = s;
			this.server = server;
		}
		
		public void run(){
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				while (!client.isClosed()) {
					String line = in.readLine();
					System.out.println(client.getInetAddress() + ": " + line);
					
					if(line.contains("/status")){
						server.getStatus();
					}
				}
				client.close();
			} catch (Exception e) {
				System.out.println("Kan inte läsa");
			}
		}
}
