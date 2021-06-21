import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class SerializationEx {
	public static void main(String[] args) {
		try {
			Employee emp1 = new Employee(2011, "Geralt","Witcher","Vesemir");
			Employee emp2 = new Employee(2020, "Ciri","Witcher","Vesemir");
			Employee emp3 = new Employee(2011, "Yennefer","Witch","Radovid");
			FileOutputStream fout = new FileOutputStream("output.ser");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(emp1);
			out.writeObject(emp2);
			out.writeObject(emp3);
			
//			out.flush();
			out.close();
			System.out.println("Serialization and DeSerialization has been successfully executed");
//			System.out.println(emp2.boss);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

