import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SerializeSocketClient {
	private String address = "127.0.0.1";// 連線的ip
	private int port = 8765;// 連線的port

	public SerializeSocketClient() {
		Employee clientEmployee = new Employee(2011, "Geralt","Witcher","Vesemir");
		Socket client = new Socket();
		InetSocketAddress isa = new InetSocketAddress(this.address, this.port);
		try {
			client.connect(isa, 10000);
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
//			不知道為啥不能寫成try-with 看是不是closable
			out.writeObject(clientEmployee);
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
	public static void main(String[] args) {
		new SerializeSocketClient();
	}
}
