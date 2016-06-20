package ServerSide2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import GUI.ServerGUI;

public class ServerConnectorT extends Thread{
	
	private Server2 s2;
	private ServerSocket server;
	private ServerGUI sG;
	private ArrayList<Socket> clients; 
	private ArrayList<ServStreamL2> clientConns;
	
	public ServerConnectorT(ServerGUI sG, Server2 s2, ServerSocket server, ArrayList<Socket> clients, ArrayList<ServStreamL2> clientConns){
		this.s2 = s2;
		this.server = server;
		this.sG = sG;
		this.clients = clients;
		this.clientConns = clientConns;
	}
	
	public void run(){
		try{
			while(true){
				Socket client = server.accept();
				sG.appendChat("Made connection with: " + client.getInetAddress().toString() + " on: " + client.getPort());
				clients.add(client);
				
				ServStreamL2 listener = new ServStreamL2(s2, client, sG);
				clientConns.add(listener);
				listener.start();
			}
		} catch(Exception e){}
	}

}
