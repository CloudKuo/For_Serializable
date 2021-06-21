import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SerializeSocketClient {
	private String address = "127.0.0.1";// �s�u��ip
	private int port = 8765;// �s�u��port

	public SerializeSocketClient() {
		Employee clientEmployee = new Employee(2011, "Geralt","Witcher","Vesemir");
		Socket client = new Socket();
		InetSocketAddress isa = new InetSocketAddress(this.address, this.port);
		try {
			client.connect(isa, 10000);
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
//			�����D��ԣ����g��try-with �ݬO���Oclosable
			out.writeObject(clientEmployee);
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
	public static void main(String[] args) {
		new SerializeSocketClient();
	}
}
