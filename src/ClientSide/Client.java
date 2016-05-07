package ClientSide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Files;

public class Client {
	
	public static void main(String[] args){
		try {
			Socket s = new Socket(InetAddress.getLocalHost(), 30000);
			
			System.out.println("SKRIV");
			
			Thread listener = new ClientStreamL(s);
			listener.start();
			Thread Writer = new ClientStreamW(s);
			Writer.start();
			
			System.out.println("-BEGIN SEND-");
			File file = new File("src/pic1.jpg");
			//FileOutputStream fop = new FileOutputStream(file);
//			if (!file.exists()) {
//				file.createNewFile();
//				System.out.println("FILE MADE");
//			}
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream()); //Socket 2 server	
			byte[] content = Files.readAllBytes(file.toPath());
			oos.writeObject(content);
			
			System.out.println("-END SEND-");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
