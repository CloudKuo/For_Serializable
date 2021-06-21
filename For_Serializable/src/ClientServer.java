import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class ClientServer {
	private String address = "127.0.0.1";// 連線的ip
	private int port = 8888;// 連線的port

	public ClientServer() {
		Scanner mySt = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = mySt.nextLine();
		Socket client = new Socket();
		InetSocketAddress isa = new InetSocketAddress(this.address, this.port);
		try {
			client.connect(isa, 10000);
			BufferedOutputStream out = new BufferedOutputStream(client.getOutputStream());
//			不知道為啥不能寫成try-with
			out.write(("Your name: "+name).getBytes());
			// 送出字串
			out.flush();
			out.close();
			out = null;
			client.close();
			client = null;
			System.out.println("Already Send your message");
		} catch (IOException e) {
			System.out.println("Socket連線有問題 !");
			System.out.println("IOException :" + e.toString());
		}
	}

	public static void main(String args[]) {
		new ClientServer();
	}
}
