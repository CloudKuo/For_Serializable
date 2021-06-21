import java.io.Serializable;
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	transient String corp;
	static transient  String boss = "initial boss";

	public Employee(int id, String name, String corp, String boss) {
		this.id = id;
		this.name = name;
		this.corp = corp;
		this.boss = boss;
//		System.out.println(boss);
//		System.out.println(this.boss);
	}
	public String getName() {
		return name;
	}
}
