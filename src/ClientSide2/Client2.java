package ClientSide2;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.file.Files;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import GUI.ClientGUI;
import Util.Doc;
import Util.Paket;

public class Client2 {
	
	private Socket s;
	private ClientGUI cG;
	private ObjectOutputStream oos;
	
	public Client2(ClientGUI cG){
		this.cG = cG;	
		this.oos = null;
	}
	
	public void connect(String ip, int port){
		try {
			s = new Socket();
			InetAddress addr = InetAddress.getByName(ip);
			SocketAddress sockAddr = new InetSocketAddress(addr, port);

			s.connect(sockAddr, 10000);	
			cG.clearChat();
			cG.appendChat("Connected to a SuperFileTransfer Server!");
			
			Thread listener = new ClientStreamL2(s, cG);
			listener.start();
			
			oos = new ObjectOutputStream(s.getOutputStream());
//			Thread Writer = new ClientStreamW2(s);
//			Writer.start();
			
		} catch (Exception e) {
			cG.clearChat();
			cG.appendChat("Connection refused for random reason.");
			System.out.println("--ERROR CONN NOT EST--");
			e.printStackTrace();
			return;
		}
	}
	
	public void sendChat(String text){
		try{
			String type = text;				
			Paket pak1 = generatePaket(type);
			oos.writeObject(pak1);
		} catch (Exception e){}	
	}
	
	public void sendFile(){
		Paket pac = null;
		try {
			JFileChooser fileChooser = new JFileChooser();
			if (fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
			  File file = fileChooser.getSelectedFile();
			  String name = file.getName();
			  pac = new Paket("file", new Doc(name, Files.readAllBytes(file.toPath())));
			  cG.appendChat("A file was sent to the server!");
			  cG.appendChat(name);
			} else {
				pac = new Paket("ERROR",  new Doc("ERROR", "ERROR".getBytes()));
			}
		} catch (Exception e) {
			pac = new Paket("ERROR",  new Doc("ERROR", "ERROR".getBytes()));
			cG.appendChat("File was somehow not found");
		};
		try {
			oos.writeObject(pac);
		} catch (IOException e) {}
	}
	
	private Paket generatePaket(String type){
		Paket pac;
		switch (type){
		
		case "/file":
			try {
				pac = null;
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
				  File file = fileChooser.getSelectedFile();
				  String name = file.getName();
				  pac = new Paket("file", new Doc(name, Files.readAllBytes(file.toPath())));
				  cG.appendChat("A file was sent to the server!");
				  cG.appendChat(name);
				} else {
					pac = new Paket("ERROR",  new Doc("ERROR", "ERROR".getBytes()));
				}
			} catch (Exception e) {
				pac = new Paket("ERROR",  new Doc("ERROR", "ERROR".getBytes()));
				//System.out.println("The File was not found or isnt a file, make sure to input [NAME].[TYPE]");
				cG.appendChat("File was somehow not found");
			};
			return pac;
			
		default:
			try{
				pac = new Paket("chat", new Doc(InetAddress.getLocalHost().getHostAddress(), type.getBytes()));
				return pac;
			} catch (IOException e){
				pac = new Paket("ERROR",  new Doc("ERROR", "ERROR".getBytes()));
				return pac;
			}
		}
	}
}
