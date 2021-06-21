package SerInheritancePack;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//example for subclass implements Serializable
class C {
	int i;
	public C(int i) {
		this.i=i;
	}
	public C() {
		i = 50;
//		如果上面這行沒打，就會將初始值取出而已，因為superclass沒有序列化 會印出第10行初始的值
		System.out.println("C empty constructor called");
	}
}

class D extends C implements Serializable{
	int j;
	public D(int i, int j) {
		super(i);
//		在這裡轉換值的
		this.j=j;
	}
}
public class SecEx {
	public static void main(String[] args) throws Exception{
		D dd = new D(10,20);
		System.out.println("i= "+dd.i);
		System.out.println("j= "+dd.j);
		try (FileOutputStream fos = new FileOutputStream("Sec.ser");
				ObjectOutputStream os = new ObjectOutputStream(fos)) {
			os.writeObject(dd);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Object has been serialized");
		try(FileInputStream fis = new FileInputStream("Sec.ser");
				ObjectInputStream is = new ObjectInputStream(fis)){
			D dede = (D)is.readObject();
//			在這裡call D constructor的
			System.out.println("Object has been deserialized");
			System.out.println("i= "+dede.i);
			System.out.println("j= "+dede.j);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
