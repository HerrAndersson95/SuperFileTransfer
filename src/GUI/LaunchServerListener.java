package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ServerSide2.Server2;

public class LaunchServerListener implements ActionListener{
	
	private ServerGUI sG;
	private Server2 s2;
	
	public LaunchServerListener(ServerGUI sG, Server2 s2){
		this.sG = sG;
		this.s2 = s2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int port;
		sG.clearChat();
		try{
			port = Integer.parseInt(sG.getPort());			
		} catch (NumberFormatException e1){
			sG.appendChat("Invalid port");
			return;
		}
		s2.init(port);
	}

}
