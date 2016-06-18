package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ClientSide2.Client2;

public class ChatInputListener implements ActionListener {
	
	private Client2 c;
	private ClientGUI cG;
	
	public ChatInputListener(ClientGUI cG, Client2 c){
		this.c = c;
		this.cG = cG;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		c.sendChat(cG.getChatInput());
	}
}
