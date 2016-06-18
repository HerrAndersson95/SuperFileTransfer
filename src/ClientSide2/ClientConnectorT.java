package ClientSide2;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientConnectorT extends Thread{
	
	private Client2 c;
//	private Socket s;
//	private SocketAddress sockAddr;
	
	public ClientConnectorT(Client2 c){ //SocketAddress sockAddr
		this.c = c;
//		this.s = s;
//		this.sockAddr = sockAddr;
	}
	
	public void run(){
		System.out.println("THREAD RUNNING");
//		boolean connected = false;
//		System.out.println("CONNECT THREAD START");
//		try {
//			s.connect(sockAddr, 10000);
//			connected = true;
//		} catch (IOException e) {
//		}
//		
//		c.connectResponse(connected);
//		System.out.println("CONNECT THREAD DONE");
	}
	public void connect(Socket s, SocketAddress sockAddr){
		boolean connected = false;
		System.out.println("CONNECT THREAD START");
		try {
			s.connect(sockAddr, 10000);
			connected = true;
		} catch (IOException e) {
		}
		
		//c.connectResponse(connected);
		System.out.println("CONNECT THREAD DONE");
	}
}
