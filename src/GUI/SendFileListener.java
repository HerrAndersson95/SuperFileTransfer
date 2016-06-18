package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ClientSide2.Client2;

public class SendFileListener implements ActionListener{
	
	private Client2 c;
	
	public SendFileListener(Client2 c){
		this.c = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		c.sendFile();
	}
}
