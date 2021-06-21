import java.io.BufferedInputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class SocketServer extends Thread{
	private boolean OutServer = false;
	public static ServerSocket server;
	private final int ServerPort = 8888;// �n�ʱ���port
	public SocketServer() {
		try {
			server = new ServerSocket(ServerPort);
		} catch (java.io.IOException e) {
			System.out.println("Socket�Ұʦ����D !");
			System.out.println("IOException :" + e.toString());
		}
	}
	
	public void run() {
		Socket socket;
		BufferedInputStream in;
		System.out.println("���A���w�Ұ� !");
		while (!OutServer) {
			socket = null;
			try {
				synchronized (server) {
					socket = server.accept();
				}
				System.out.println("���o�s�u : InetAddress IP = " + socket.getInetAddress());
				// TimeOut�ɶ�
				socket.setSoTimeout(15000);
				in = new BufferedInputStream(socket.getInputStream());
				byte[] b = new byte[1024];
				String data = "";
				int length;
				while ((length = in.read(b)) > 0) {// <=0���ܴN�O�����F
					data += new String(b, 0, length);
				}
				System.out.println("�ڨ��o����:" + data);
				in.close();
				in = null;
				socket.close();
			} catch (java.io.IOException e) {
				System.out.println("Socket�s�u�����D !");
				System.out.println("IOException :" + e.toString());
			}
		}
	}

	public static void main(String args[]) {
		(new SocketServer()).run();
	}

}
