package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import ClientSide2.Client2;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientGUI {

	private JFrame frmSuperfiletransfer;
	private JTextField txtSeverIp;
	private JTextField ServerIPIn;
	private JTextField txtSeverPort;
	private JTextField ServerPortIn;
	private JButton btnConnect;
	private JTextField ChatInput;
	private JScrollPane scrollPane;
	private JTextArea ChatArea;
	private JButton btnSendFile;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frmSuperfiletransfer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//PRE CODE
		Client2 client = new Client2(this);
		//END PRE CODE
		
		frmSuperfiletransfer = new JFrame();
		frmSuperfiletransfer.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmSuperfiletransfer.setTitle("SuperFileTransfer");
		frmSuperfiletransfer.setBounds(100, 100, 450, 300);
		
		frmSuperfiletransfer.setMinimumSize(new Dimension(530 , 300));
		
		frmSuperfiletransfer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 60, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frmSuperfiletransfer.getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frmSuperfiletransfer.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		txtSeverIp = new JTextField();
		txtSeverIp.setEditable(false);
		txtSeverIp.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeverIp.setText("Sever IP");
		GridBagConstraints gbc_txtSeverIp = new GridBagConstraints();
		gbc_txtSeverIp.insets = new Insets(0, 0, 5, 5);
		gbc_txtSeverIp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSeverIp.gridx = 0;
		gbc_txtSeverIp.gridy = 0;
		panel.add(txtSeverIp, gbc_txtSeverIp);
		txtSeverIp.setColumns(10);
		
		ServerIPIn = new JTextField();
		ServerIPIn.setHorizontalAlignment(SwingConstants.CENTER);
		ServerIPIn.setText("x.x.x.x");
		GridBagConstraints gbc_ServerIPIn = new GridBagConstraints();
		gbc_ServerIPIn.insets = new Insets(0, 0, 5, 0);
		gbc_ServerIPIn.fill = GridBagConstraints.HORIZONTAL;
		gbc_ServerIPIn.gridx = 1;
		gbc_ServerIPIn.gridy = 0;
		panel.add(ServerIPIn, gbc_ServerIPIn);
		ServerIPIn.setColumns(10);
		
		txtSeverPort = new JTextField();
		txtSeverPort.setEditable(false);
		txtSeverPort.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeverPort.setText("Sever Port");
		GridBagConstraints gbc_txtSeverPort = new GridBagConstraints();
		gbc_txtSeverPort.insets = new Insets(0, 0, 5, 5);
		gbc_txtSeverPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSeverPort.gridx = 0;
		gbc_txtSeverPort.gridy = 1;
		panel.add(txtSeverPort, gbc_txtSeverPort);
		txtSeverPort.setColumns(10);
		
		ServerPortIn = new JTextField();
		ServerPortIn.setHorizontalAlignment(SwingConstants.CENTER);
		ServerPortIn.setText("x");
		GridBagConstraints gbc_ServerPortIn = new GridBagConstraints();
		gbc_ServerPortIn.insets = new Insets(0, 0, 5, 0);
		gbc_ServerPortIn.fill = GridBagConstraints.HORIZONTAL;
		gbc_ServerPortIn.gridx = 1;
		gbc_ServerPortIn.gridy = 1;
		panel.add(ServerPortIn, gbc_ServerPortIn);
		ServerPortIn.setColumns(10);
		
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ConnectListener(this, client));	//LISTENER
		
		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.insets = new Insets(0, 0, 5, 0);
		gbc_btnConnect.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConnect.gridwidth = 2;
		gbc_btnConnect.gridx = 0;
		gbc_btnConnect.gridy = 2;
		panel.add(btnConnect, gbc_btnConnect);
		
		btnSendFile = new JButton("Send file");
		btnSendFile.addActionListener(new SendFileListener(client));
		
		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.gridheight = 5;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 3;
		panel.add(separator, gbc_separator);
		GridBagConstraints gbc_btnSendFile = new GridBagConstraints();
		gbc_btnSendFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSendFile.gridwidth = 2;
		gbc_btnSendFile.anchor = GridBagConstraints.SOUTH;
		gbc_btnSendFile.gridx = 0;
		gbc_btnSendFile.gridy = 8;
		panel.add(btnSendFile, gbc_btnSendFile);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		frmSuperfiletransfer.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		ChatArea = new JTextArea();
		ChatArea.setEditable(false);
		ChatArea.setText("Chat Area");
		scrollPane.setViewportView(ChatArea);
		
		ChatInput = new JTextField();
		ChatInput.addActionListener(new ChatInputListener(this, client)); //LISTERNER
		
		ChatInput.setText("Chat Input");
		GridBagConstraints gbc_ChatInput = new GridBagConstraints();
		gbc_ChatInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_ChatInput.gridx = 0;
		gbc_ChatInput.gridy = 1;
		panel_1.add(ChatInput, gbc_ChatInput);
		ChatInput.setColumns(10);
		
		// END INIT CODE
		clearChat();
		appendChat("Welcome to the SuperServer Graphical Client!");
		appendChat("Connection Timout set to 10s.");
		// END
	}
	
	public synchronized String getIP(){
		return ServerIPIn.getText();
	}
	public synchronized String getPort(){
		return ServerPortIn.getText();
	}
	public synchronized void clearChat(){
		ChatArea.setText("");
	}
	public synchronized void appendChat(String text){
		ChatArea.append(text + "\n");
	}
	public String getChatInput(){
		String text = ChatInput.getText();
		ChatInput.setText("");
		return text;
	}
}
