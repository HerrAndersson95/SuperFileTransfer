package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ClientSide2.Client2;

public class ConnectListener implements ActionListener{
	
	private ClientGUI cG;
	private Client2 client;
	
	public ConnectListener(ClientGUI cG, Client2 client){
		this.cG = cG;
		this.client = client;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String ip = cG.getIP();
		int port;
		try{
			port = Integer.parseInt(cG.getPort()); 
		} catch (NumberFormatException e1){
			cG.clearChat();
			cG.appendChat("Invalid port");
			return;
		}
		client.connect(ip, port);
	}
}
