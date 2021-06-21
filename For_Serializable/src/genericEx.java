import java.util.*;
class MyGe <E>{
	private String name;
	private Object[] l ;
	private int next;
	E obj;
	public void setName(String name, E e) {
		this.name = name;
		System.out.println("This type name "+name+"thing is "+e);
	}
	public MyGe(int ca) {
		l = new Object[ca];
	}
	public MyGe(E obj) {
		this.obj = obj;
	}
	public MyGe(){
		this(16);
	}
	public void add(E e) {
		if (next == l.length) {
			l = Arrays.copyOf(l, l.length*2);
		}
		l[next++] = e;
	}
	@SuppressWarnings("unchecked")
	public E get(int index) {
		
		return (E) l[index];
	}
	public E getObject() {
		return this.obj;
	}
}
class questionMarkEx{
	class A {
		 
	}
	 
	class B extends A {
	 
	}
	 
	class C extends B {
	 
	}
	 
	class Q {
	 
	}
	List<?> list11 = new ArrayList<B>();
	List<?> list12 = new ArrayList<Object>();
	List<?> list13 = new ArrayList();
	List<?> list14 = new ArrayList<>();
	
	List<? extends B> list15 = new ArrayList();
	List<? super B> list16 = new ArrayList();
	void testExtendSuper() {
		//list15.add(new A()); // �sĶ���~
		((List) list15).add(new A()); // �n��list15�ܼƱj���૬
		//list15.add(new B()); // �sĶ���~
		((List) list15).add(new B()); // �n��list15�ܼƱj���૬
		//list15.add(new C()); // �sĶ���~
		((List) list15).add(new C()); // �n��list15�ܼƱj���૬
		//list15.add(new Q()); // �sĶ���~
		((List) list15).add(new Q()); // �n��list15�ܼƱj���૬
		A a15 = list15.get(0);
		B b15 = list15.get(1);
		C c15 = (C) list15.get(2);
		// Q q15 = (Q) list15.get(3); // �|�sĶ���~�A�L�k��������o�������j���૬
		Q q15 = (Q) ((List) list15).get(3); // �n��list15�ܼƱj���૬

		//list16.add(new A()); // �sĶ���~
		((ArrayList) list16).add(new A()); // �n��list16�ܼƱj���૬
		list16.add(new B());
		list16.add(new C());
		//list16.add(new Q()); // �sĶ���~
		((ArrayList) list16).add(new Q()); // �n��list16�ܼƱj���૬
		A a16 = (A) list16.get(0);
		B b16 = (B) list16.get(1);
		C c16 = (C) list16.get(2);
		Q q16 = (Q) list16.get(3);
		System.out.format("Extend and Super list 15: %s %s %s %s\n",a15,b15,c15,q15);
		System.out.format("Extend and Super list 16: %s %s %s %s\n",a16,b16,c16,q16);
	}
	void testAdd() {
		//list11.add(new A()); // �sĶ���~
		((ArrayList) list11).add(new A()); // �n��list11�ܼƱj���૬
		//list11.add(new B()); // �sĶ���~
		((ArrayList) list11).add(new B()); // �n��list11�ܼƱj���૬
		//list11.add(new C()); // �sĶ���~
		((ArrayList) list11).add(new C()); // �n��list11�ܼƱj���૬
		//list11.add(new Q()); // �sĶ���~
		((ArrayList) list11).add(new Q()); // �n��list11�ܼƱj���૬
		A a4 = (A) list11.get(0);
		B b4 = (B) list11.get(1);
		C c4 = (C) list11.get(2);
		Q q4 = (Q) list11.get(3);
		System.out.format("%s %s %s %s\n",a4,b4,c4,q4);
		
		Object o = new Object();
//		list11.add(o); // �sĶ���� �ҥH?���Oobject���A
//		�u?�v�N��ۥ����A�����D�|�ǤJ��˪�����A�ҥH�L�k�O�ҶǤJ���󪺫��A�C���O�^�Ǫ����p�N���P�F�A����������A�@�w�O�@�ӡuObject�v����A�ҥH�^�Ǫ����󤸯��ѦҡA�i�H�ϥ�Object���A���ܼƨ��x�s�C
		o = list11.get(0);
//		list11.add(list11.get(0)); // �sĶ���� �Y�K�O�q�ۤv�������X���u?�v���A�������A�]�L�k�����@���ѼƶǦ^�ۤv�����C
	}
}
public class genericEx {
	public static void main(String[] args) {
		questionMarkEx qInstance = new questionMarkEx();
		qInstance.testAdd();
//		qInstance.testExtendSuper();
		MyGe<String> m = new MyGe<>(16);
		m.setName("String", "test");
		m.add("ge");
		String n1 = m.get(0);
//		m.setName("String",111);
		MyGe<String> m3 = new MyGe<>("test");
		MyGe<Float> i = new MyGe<>(5.5f);
//		i = m3;
//		cannot convert from MyGe<String> to MyGe<Float>
		
		
		MyGe m2 = new MyGe();
		m2.add("not ge");
		String n2 = (String)m2.get(0);
		System.out.println(n1+" "+n2);
		List<MyGe<? extends Object>> list = new ArrayList<>();
        list.add(m);
        list.add(i);
        list.add(m3);
       
        for (MyGe<?> e : list) {
            System.out.println(e);
        }
		
		
	}
}
