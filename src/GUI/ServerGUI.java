package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;

import ServerSide2.Server2;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerGUI {

	private JFrame frmSuperfileserer;
	private JTextField txtMachineIp;
	private JTextField ServerIP;
	private JTextField txtPort;
	private JTextField ServerPort;
	private JTextField txtServerSaveLocation;
	private JTextField SaveLocation;
	private JTextField txtServerControlWindow;
	private JScrollPane scrollPane;
	private JTextArea ControlArea;
	private JButton btnInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI window = new ServerGUI();
					window.frmSuperfileserer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//PRE CODE
		Server2 server = new Server2(this);
		//END PRE CODE
				
		frmSuperfileserer = new JFrame();
		frmSuperfileserer.setTitle("SuperFileTransferServer");
		frmSuperfileserer.setBounds(100, 100, 450, 300);
		
		frmSuperfileserer.setMinimumSize(new Dimension(530 , 300));
		
		frmSuperfileserer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 60, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frmSuperfileserer.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(235 , 300));
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frmSuperfileserer.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		txtMachineIp = new JTextField();
		txtMachineIp.setEditable(false);
		txtMachineIp.setText("Machine IP");
		txtMachineIp.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_txtMachineIp = new GridBagConstraints();
		gbc_txtMachineIp.insets = new Insets(0, 0, 5, 5);
		gbc_txtMachineIp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMachineIp.gridx = 0;
		gbc_txtMachineIp.gridy = 0;
		panel.add(txtMachineIp, gbc_txtMachineIp);
		txtMachineIp.setColumns(10);
		
		ServerIP = new JTextField();
		ServerIP.setHorizontalAlignment(SwingConstants.CENTER);
		ServerIP.setText("plz connect ");
		ServerIP.setEditable(false);
		GridBagConstraints gbc_ServerIP = new GridBagConstraints();
		gbc_ServerIP.insets = new Insets(0, 0, 5, 0);
		gbc_ServerIP.fill = GridBagConstraints.HORIZONTAL;
		gbc_ServerIP.gridx = 1;
		gbc_ServerIP.gridy = 0;
		panel.add(ServerIP, gbc_ServerIP);
		ServerIP.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setEditable(false);
		txtPort.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort.setText("Port");
		GridBagConstraints gbc_txtPort = new GridBagConstraints();
		gbc_txtPort.insets = new Insets(0, 0, 5, 5);
		gbc_txtPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPort.gridx = 0;
		gbc_txtPort.gridy = 1;
		panel.add(txtPort, gbc_txtPort);
		txtPort.setColumns(10);
		
		ServerPort = new JTextField();
		ServerPort.setHorizontalAlignment(SwingConstants.CENTER);
		ServerPort.setText("X");
		GridBagConstraints gbc_ServerPort = new GridBagConstraints();
		gbc_ServerPort.insets = new Insets(0, 0, 5, 0);
		gbc_ServerPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_ServerPort.gridx = 1;
		gbc_ServerPort.gridy = 1;
		panel.add(ServerPort, gbc_ServerPort);
		ServerPort.setColumns(10);
		
		JButton btnLaunchServer = new JButton("Launch Server");
		GridBagConstraints gbc_btnLaunchServer = new GridBagConstraints();
		
		btnLaunchServer.addActionListener(new LaunchServerListener(this, server));
		
		gbc_btnLaunchServer.insets = new Insets(0, 0, 5, 0);
		gbc_btnLaunchServer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLaunchServer.gridwidth = 2;
		gbc_btnLaunchServer.gridx = 0;
		gbc_btnLaunchServer.gridy = 2;
		panel.add(btnLaunchServer, gbc_btnLaunchServer);
		
		btnInfo = new JButton("Info!");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearChat();
				appendChat("----INFO----");
				appendChat("Program created by:");
				appendChat("FluxKondensator / Joakim Andersson");
				appendChat("");
				appendChat("----PROGRAM----");
				appendChat("This is the graphical GUI to my little Client/Server communication program.");
				appendChat("It is capable of chatting with people connected to the main computer server");
				appendChat("Main function is being able to send file to the server");
				appendChat("(THIS IS THE SERVER GUI)");
				appendChat("Q: How large files can I recieve?");
				appendChat("A: How much RAM do you have?");
				appendChat("Q: Does it work ever the radical internet?");
				appendChat("A: Portforward that shit! Then yes.");
				appendChat("Q: Is it as 'Super' as you claim?");
				appendChat("A: AWW HELL YES!");
				appendChat("");
				appendChat("----USAGE----");
				appendChat("Enter the Port that the server shall be running on!");
				appendChat("Want to use it over the internet? Portforward it!");
				appendChat("Slap that Launch Server!");
				appendChat("Pray for no Errors and you should be going! (Not my fault if it doesnt work)");
				appendChat("In the ControlArea you can see status things.");
				appendChat("MAKE SURE TO CHANGE FILE LOCATION");
				appendChat("(Im not sure where the file might end up...)");
				appendChat("You are gooood to go mate!");
				appendChat("");
			}
		});
		GridBagConstraints gbc_btnInfo = new GridBagConstraints();
		gbc_btnInfo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInfo.gridwidth = 2;
		gbc_btnInfo.insets = new Insets(0, 0, 5, 0);
		gbc_btnInfo.gridx = 0;
		gbc_btnInfo.gridy = 3;
		panel.add(btnInfo, gbc_btnInfo);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridheight = 2;
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 4;
		panel.add(separator, gbc_separator);
		
		txtServerSaveLocation = new JTextField();
		txtServerSaveLocation.setEditable(false);
		txtServerSaveLocation.setHorizontalAlignment(SwingConstants.CENTER);
		txtServerSaveLocation.setText("Server save location");
		GridBagConstraints gbc_txtServerSaveLocation = new GridBagConstraints();
		gbc_txtServerSaveLocation.insets = new Insets(0, 0, 5, 0);
		gbc_txtServerSaveLocation.gridwidth = 2;
		gbc_txtServerSaveLocation.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtServerSaveLocation.gridx = 0;
		gbc_txtServerSaveLocation.gridy = 6;
		panel.add(txtServerSaveLocation, gbc_txtServerSaveLocation);
		txtServerSaveLocation.setColumns(10);
		
		SaveLocation = new JTextField();
		SaveLocation.setEditable(false);
		SaveLocation.setHorizontalAlignment(SwingConstants.CENTER);
		SaveLocation.setText("DEFAULT");
		GridBagConstraints gbc_SaveLocation = new GridBagConstraints();
		gbc_SaveLocation.insets = new Insets(0, 0, 5, 0);
		gbc_SaveLocation.gridwidth = 2;
		gbc_SaveLocation.fill = GridBagConstraints.HORIZONTAL;
		gbc_SaveLocation.gridx = 0;
		gbc_SaveLocation.gridy = 7;
		panel.add(SaveLocation, gbc_SaveLocation);
		SaveLocation.setColumns(10);
		
		JButton btnChangeLocation = new JButton("Change Location");
		GridBagConstraints gbc_btnChangeLocation = new GridBagConstraints();
		
		btnChangeLocation.addActionListener(new ChangeLocationListener(server));
		
		gbc_btnChangeLocation.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnChangeLocation.gridwidth = 2;
		gbc_btnChangeLocation.gridx = 0;
		gbc_btnChangeLocation.gridy = 8;
		panel.add(btnChangeLocation, gbc_btnChangeLocation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		frmSuperfileserer.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		txtServerControlWindow = new JTextField();
		txtServerControlWindow.setEditable(false);
		txtServerControlWindow.setHorizontalAlignment(SwingConstants.CENTER);
		txtServerControlWindow.setText("Server Control Window");
		GridBagConstraints gbc_txtServerControlWindow = new GridBagConstraints();
		gbc_txtServerControlWindow.insets = new Insets(0, 0, 5, 0);
		gbc_txtServerControlWindow.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtServerControlWindow.gridx = 0;
		gbc_txtServerControlWindow.gridy = 0;
		panel_1.add(txtServerControlWindow, gbc_txtServerControlWindow);
		txtServerControlWindow.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		ControlArea = new JTextArea();
		ControlArea.setEditable(false);
		scrollPane.setViewportView(ControlArea);
		DefaultCaret caret = (DefaultCaret)ControlArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
	}
	
	public String getPort(){
		return ServerPort.getText();
	}
	
	public void clearChat(){
		ControlArea.setText("");
	}
	
	public void appendChat(String s){
		ControlArea.append(s + "\n");
	}
	
	public void setIP(String ip){
		ServerIP.setText(ip);
	}
	
	public void setSavePath(String path){
		SaveLocation.setText(path);
	}
}
