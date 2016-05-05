package ServerSide;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	private static int port = 30000;
	private ArrayList<Socket> clients;
	
	public Server(){
		clients = new ArrayList<Socket>();
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("Server up");
			
			while(true){
				Socket client = server.accept();
				System.out.println("Made connection with: " + client.getInetAddress().toString() + "on: " + client.getPort());
				clients.add(client);
				System.out.println("ADDED client");
				
				Thread listener = new ServStreamL(this, client);
				listener.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getStatus(){
		for(Socket s : clients){
			try {
				PrintWriter out = new PrintWriter(new BufferedOutputStream(s.getOutputStream()), true);
				out.println("Welcome user to the shittiest server ever.");
			} catch (IOException e) { }
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
	}

}
