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
//		�p�G�W���o��S���A�N�|�N��l�Ȩ��X�Ӥw�A�]��superclass�S���ǦC�� �|�L�X��10���l����
		System.out.println("C empty constructor called");
	}
}

class D extends C implements Serializable{
	int j;
	public D(int i, int j) {
		super(i);
//		�b�o���ഫ�Ȫ�
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
//			�b�o��call D constructor��
			System.out.println("Object has been deserialized");
			System.out.println("i= "+dede.i);
			System.out.println("j= "+dede.j);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
