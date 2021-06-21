import java.io.*;
class Test implements Serializable{
	transient int i=2;
	static transient int j = 4;
	int k =6;
}
public class TransientSample{
	public static void main (String[] args){
		String fileName1 = "TestFile.txt";
		Test obj = new Test();
		obj.i = 3;
		obj.j = 5;
		obj.k = 7;
		
		try {
			FileOutputStream fos = new FileOutputStream(fileName1);
			ObjectOutputStream objo = new ObjectOutputStream(fos);
			objo.writeObject(obj);
			
			FileInputStream fis = new FileInputStream(fileName1);
			ObjectInputStream obji = new ObjectInputStream(fis);
			Test obj1 =(Test) obji.readObject();

			System.out.println(obj1.i + " " + obj1.j + " " + obj1.k);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
}