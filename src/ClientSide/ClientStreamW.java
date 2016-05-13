package ClientSide;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;

import Util.Doc;
import Util.Paket;

public class ClientStreamW extends Thread{
	
	private Socket client;
	private BufferedReader in;
	
	public ClientStreamW(Socket s){
		this.client = s;
		in = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public void run(){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
			System.out.println("-- SYSTEM WAITING INPUT --");
			while (!client.isClosed()) {
				String type = in.readLine();				
				Paket pak1 = generatePaket(type);
				oos.writeObject(pak1);				
			}
			client.close();
		} catch (Exception e) {}
	}
	
	private Paket generatePaket(String type){
		Paket pac;
		switch (type){
		
		case "/file":
			System.out.println("INPUT COMPLETE FILE NAME FROM 'files' FOLDER");
			try {
				String name = in.readLine();
				File file = new File("src/"+name);
				pac = new Paket("file", new Doc(name, Files.readAllBytes(file.toPath())));
				System.out.println("Sent file");
			} catch (IOException e) {
				pac = new Paket("ERROR",  new Doc("ERROR", "ERROR".getBytes()));
				System.out.println("Sent Error");	
				e.printStackTrace();
			};
			return pac;
			
		default:
			pac = new Paket("chat", new Doc(client.getInetAddress().toString(), type.getBytes()));
			return pac;
		}
	}

}
