package ServerSide2;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import GUI.ServerGUI;
import Util.Doc;
import Util.Paket;

public class Server2 {
	
	private int port;
	private ArrayList<Socket> clients;
	private ArrayList<ServStreamL2> clientConns;
	private String savePath;
	
	private ServerGUI sG;
	
	public Server2(ServerGUI sG){
		this.sG = sG;
		this.savePath = "";
	}
	
	public void init(int port){
		this.port = port;
		clients = new ArrayList<Socket>();
		clientConns = new ArrayList<ServStreamL2>();
		try {
			ServerSocket server = new ServerSocket(port);
			sG.setIP(InetAddress.getLocalHost().getHostAddress());
			sG.clearChat();
			sG.appendChat("Server up and listening!");
			sG.appendChat(""+port);
			
			ServerConnectorT connector = new ServerConnectorT(sG, this, server, clients, clientConns);
			connector.start();
		} catch (Exception e) {
			sG.appendChat("Something went wrong -win10");
			sG.appendChat("No, but really the selected port might be occupied");
			//e.printStackTrace();
		}
	}
		
	public void receiveFile(Doc doc){
		try {
			File file = new File(savePath + doc.getTitle());	//"filesR/"
			Files.write(file.toPath(), doc.getContent());
			System.out.println("File " + doc.getTitle() + " saved");
			sG.appendChat("File: " + doc.getTitle() + " saved to: " + savePath);
		} catch (IOException e) {
			sG.appendChat("ERROR while trying to save...");
			e.printStackTrace();
		}
	}
	
	public void setSavePath(){
		try {
			JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			
			if (fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
			  File file = fileChooser.getSelectedFile();			  
			  savePath = file.getAbsolutePath() + "/";
			  sG.appendChat("new savepath engaged!");
			  sG.setSavePath(savePath);
			} else {
				
			}
		} catch (Exception e) {
			
		};
	}
	
	public void disconnUsr(Socket client){
		clients.remove(client);
	}
	
	public synchronized void sendChat(Paket pac){
		for(ServStreamL2 t : clientConns){
			t.sendToClients(pac);
		}
	}
	
	public void getCommands() {
		Paket pac = new Paket("help", new Doc("Available commands are", "/help , /file".getBytes()));
		sendChat(pac);
	}
	
}
