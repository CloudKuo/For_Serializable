import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI {
	static Socket sock;
	static DataInputStream aIn;
	static DataOutputStream aOut;
	private JFrame F = new JFrame();
	private JButton btn = new JButton("°e¥X"); 
	private static JTextArea msgArea = new JTextArea();
	private JTextField msgText = new JTextField();
	private JScrollPane jScroll = new JScrollPane(msgArea);
	private JPanel painel = new JPanel(null);
	private final static int socketPort = 8888;
	public  ClientGUI() {
		
		String userName;
		F.setTitle("Client Socket Server");
		F.setLayout(null);
//		userName = "Server :";
		btn.setBounds(30, 60, 100, 80);
		msgArea.setBounds(150, 60, 200, 80);
		msgText.setBounds(150, 150, 200, 160);
		msgText.setPreferredSize(new Dimension(50, 24));
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					aOut = new DataOutputStream(sock.getOutputStream());
					String msg = "";
					msg = msgText.getText().trim();
//					msgArea.setText(userName + msgArea.getText().trim() + "\n" + msgText.getText().trim());
					aOut.writeUTF(msg);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}

			}
		});
		F.setLocationRelativeTo(null);
		painel.add(jScroll);
		F.add(btn);
		F.add(msgArea);
		F.add(msgText);
		F.setSize(500, 400);
		F.setVisible(true);
	}
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ClientGUI();
			}
		});
		try {
			sock = new Socket("127.0.0.1",socketPort);
			aIn = new DataInputStream(sock.getInputStream());
			aOut = new DataOutputStream(sock.getOutputStream());
			String msg = "";
			while (!msg.equals("Exit")) {
				msg = aIn.readUTF();
				msgArea.setText(msgArea.getText().trim()+"\n Server:\t"+msg);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
