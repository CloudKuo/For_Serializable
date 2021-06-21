import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class ClientServer {
	private String address = "127.0.0.1";// �s�u��ip
	private int port = 8888;// �s�u��port

	public ClientServer() {
		Scanner mySt = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = mySt.nextLine();
		Socket client = new Socket();
		InetSocketAddress isa = new InetSocketAddress(this.address, this.port);
		try {
			client.connect(isa, 10000);
			BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream());
//			�����D��ԣ����g��try-with
			out.write(("Your name: "+name).getBytes());
			// �e�X�r��
			out.flush();
			out.close();
			out = null;
			client.close();
			client = null;
			System.out.println("Already Send your message");
		} catch (IOException e) {
			System.out.println("Socket�s�u�����D !");
			System.out.println("IOException :" + e.toString());
		}
	}

	public static void main(String args[]) {
		new ClientServer();
	}
}
