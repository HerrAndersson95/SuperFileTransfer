package ServerSide;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;

import Util.Doc;
import Util.Paket;

public class Server {
	
	private int port;
	private ArrayList<Socket> clients;
	private ArrayList<ServStreamL> clientConns;
	
	public Server(int port){
		this.port = port;
		clients = new ArrayList<Socket>();
		clientConns = new ArrayList<ServStreamL>();
		
		try {
			ServerSocket server = new ServerSocket(port);
			System.out.println("Server up on");
			System.out.println(InetAddress.getLocalHost());
			System.out.println(port);
			
			while(true){
				Socket client = server.accept();
				System.out.println("Made connection with: " + client.getInetAddress().toString() + " on: " + client.getPort());
				clients.add(client);
				
				ServStreamL listener = new ServStreamL(this, client);
				clientConns.add(listener);
				listener.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void receiveFile(Doc doc){
		try {
			File file = new File("src/filesR/" + doc.getTitle());
			Files.write(file.toPath(), doc.getContent());
			System.out.println("File " + doc.getTitle() + " saved");
		} catch (IOException e) {
			System.out.println("Could not save " + doc.getTitle());
		}
	}
	
	public void disconnUsr(Socket client){
		clients.remove(client);
	}
	
	public synchronized void sendChat(Paket pac){
		for(ServStreamL t : clientConns){
			t.sendToClients(pac);
		}
	}
	
	public void getCommands() {
		Paket pac = new Paket("help", new Doc("Available commands are", "/help , /file".getBytes()));
		sendChat(pac);
	}
	
	public static void main(String[] args) {
		Server server = new Server(30000);
	}


}
