package SerInheritancePack;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class A implements Serializable{
	int i;
	public A(int i ) {
		this.i=i;
	}
	public A() {
		i = 70;
		System.out.println("A empty constructor called");
	}
}

class B extends A{
	int j;
	public B(int i, int j) {
		super(i);
		this.j=j;
	}
}
public class FirstEx {
	public static void main(String[] args) throws Exception{
		B bb = new B(10,20);
		System.out.println("i= "+bb.i);
		System.out.println("j= "+bb.j);
		try (FileOutputStream fos = new FileOutputStream("First.ser");
				ObjectOutputStream os = new ObjectOutputStream(fos)) {
			os.writeObject(bb);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Object has been serialized");
		try(FileInputStream fis = new FileInputStream("First.ser");
				ObjectInputStream is = new ObjectInputStream(fis)){
			B bebe = (B)is.readObject();
			System.out.println("Object has been deserialized");
			System.out.println("i= "+bebe.i);
			System.out.println("j= "+bebe.j);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
