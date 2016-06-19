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
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		ServerIP.setText("x.x.x.x");
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
		gbc_btnLaunchServer.insets = new Insets(0, 0, 5, 0);
		gbc_btnLaunchServer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLaunchServer.gridwidth = 2;
		gbc_btnLaunchServer.gridx = 0;
		gbc_btnLaunchServer.gridy = 2;
		panel.add(btnLaunchServer, gbc_btnLaunchServer);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridheight = 3;
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 3;
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
		ControlArea.setText("Server CTRL AREA");
		scrollPane.setViewportView(ControlArea);
	}

}
