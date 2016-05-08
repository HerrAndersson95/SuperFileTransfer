package ClientSide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Files;

import Util.Paket;

public class Client {
	
	public static void main(String[] args){
		try {
			Socket s = new Socket(InetAddress.getLocalHost(), 30000);
			
			System.out.println("Connected");
			
			Thread listener = new ClientStreamL(s);
			listener.start();
			Thread Writer = new ClientStreamW(s);
			Writer.start();
			
			//----------TEST 2
//			System.out.println("START SEND");
//			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
//			Paket pak1 = new Paket("msg", "hejhej".getBytes());
//			oos.writeObject(pak1);
//			System.out.println("END SEND");
			
			//----------TEST------------
//			System.out.println("-BEGIN SEND-");
//			File file = new File("src/pic1.jpg");
//			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream()); //Socket 2 server	
//			byte[] content = Files.readAllBytes(file.toPath());
//			oos.writeObject(content);
//			System.out.println("-END SEND-");
			//------------Slut---------
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
