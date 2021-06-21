import java.io.*;
//deserialized object
public class Se {
	public static void main(String[] args) {
//		creating stream to read object
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("output.ser"))){
			Employee e1 = (Employee)in.readObject();
			Employee e2 = (Employee)in.readObject();
			Employee e3 = (Employee)in.readObject();
//			print the data of serialized object
			
			System.out.format("%d %s %s %s\n",e1.id,e1.name,e1.corp,e1.boss);
			System.out.format("%d %s %s %s\n",e2.id,e2.name,e2.corp,e2.boss);
			System.out.format("%d %s %s %s",e3.id,e3.name,e3.corp,e3.boss);
//			corp will be null boss suppose to be serialize but due to different class so the value will be initial value 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
