package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ServerSide2.Server2;

public class ChangeLocationListener implements ActionListener{
	
	private Server2 s2;
	
	public ChangeLocationListener(Server2 s2){
		this.s2 = s2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		s2.setSavePath();
	}
}
