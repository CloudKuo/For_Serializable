import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

class UI extends JFrame{
	public JButton btn = new JButton("°e¥X"); 
	public JTextArea msgArea = new JTextArea();
	public JTextField msgText = new JTextField();
	public JScrollPane jScroll = new JScrollPane(msgArea);
	public JPanel painel = new JPanel(null);
	public String userName;
	public void createGUI() {
		super.setTitle("Socket Server");
		super.setLayout(null);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		userName = "Server :";
		btn.setBounds(30,60,100,80);
		msgArea.setBounds(150,60,200,80);
		msgText.setBounds(150,150,200,160);
		msgText.setPreferredSize( new Dimension( 50, 24 ) );
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					LauncherOfSocket.bOut = new DataOutputStream(LauncherOfSocket.sock.getOutputStream());
					String msg = "";
					msg = msgText.getText().trim();
//					msgArea.setText(userName+msgArea.getText().trim()+"\n"+msgText.getText().trim());
					LauncherOfSocket.bOut.writeUTF(msg);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
//		System.out.println(saveHere);
//		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setLocationRelativeTo(null);
//		two way the window is placed in the center of the screen
		painel.add(jScroll);
		super.add(btn);
		super.add(msgArea);
		super.add(msgText);
//		super.add(jScroll);
		super.setSize(500, 400);
		super.setVisible(true);
	}
	public UI() {
	}
}

public class LauncherOfSocket {
	public static ServerSocket server;
	public static Socket sock;
	public static DataInputStream bIn;
	public static DataOutputStream bOut;
	final static int socketPort = 8888;
	public static void main(String[] args) {
		UI u = new UI();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				u.createGUI();
			}
		});
		String msg = "";
		try {
			server = new ServerSocket(socketPort);
			sock = server.accept();
			bIn = new DataInputStream(sock.getInputStream());
			bOut = new DataOutputStream(sock.getOutputStream());

			while (!msg.equals("Exit")) {
				msg = bIn.readUTF();
				u.msgArea.setText(u.msgArea.getText().trim()+"\n Client: "+msg);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
