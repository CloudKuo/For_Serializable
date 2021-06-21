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
		//list15.add(new A()); // 編譯錯誤
		((List) list15).add(new A()); // 要對list15變數強制轉型
		//list15.add(new B()); // 編譯錯誤
		((List) list15).add(new B()); // 要對list15變數強制轉型
		//list15.add(new C()); // 編譯錯誤
		((List) list15).add(new C()); // 要對list15變數強制轉型
		//list15.add(new Q()); // 編譯錯誤
		((List) list15).add(new Q()); // 要對list15變數強制轉型
		A a15 = list15.get(0);
		B b15 = list15.get(1);
		C c15 = (C) list15.get(2);
		// Q q15 = (Q) list15.get(3); // 會編譯錯誤，無法直接對取得的元素強制轉型
		Q q15 = (Q) ((List) list15).get(3); // 要對list15變數強制轉型

		//list16.add(new A()); // 編譯錯誤
		((ArrayList) list16).add(new A()); // 要對list16變數強制轉型
		list16.add(new B());
		list16.add(new C());
		//list16.add(new Q()); // 編譯錯誤
		((ArrayList) list16).add(new Q()); // 要對list16變數強制轉型
		A a16 = (A) list16.get(0);
		B b16 = (B) list16.get(1);
		C c16 = (C) list16.get(2);
		Q q16 = (Q) list16.get(3);
		System.out.format("Extend and Super list 15: %s %s %s %s\n",a15,b15,c15,q15);
		System.out.format("Extend and Super list 16: %s %s %s %s\n",a16,b16,c16,q16);
	}
	void testAdd() {
		//list11.add(new A()); // 編譯錯誤
		((ArrayList) list11).add(new A()); // 要對list11變數強制轉型
		//list11.add(new B()); // 編譯錯誤
		((ArrayList) list11).add(new B()); // 要對list11變數強制轉型
		//list11.add(new C()); // 編譯錯誤
		((ArrayList) list11).add(new C()); // 要對list11變數強制轉型
		//list11.add(new Q()); // 編譯錯誤
		((ArrayList) list11).add(new Q()); // 要對list11變數強制轉型
		A a4 = (A) list11.get(0);
		B b4 = (B) list11.get(1);
		C c4 = (C) list11.get(2);
		Q q4 = (Q) list11.get(3);
		System.out.format("%s %s %s %s\n",a4,b4,c4,q4);
		
		Object o = new Object();
//		list11.add(o); // 編譯失敗 所以?不是object型態
//		「?」代表著未知，不知道會傳入怎樣的物件，所以無法保證傳入物件的型態。但是回傳的狀況就不同了，未知的物件，一定是一個「Object」物件，所以回傳的物件元素參考，可以使用Object型態的變數來儲存。
		o = list11.get(0);
//		list11.add(list11.get(0)); // 編譯失敗 即便是從自己本身取出的「?」型態之元素，也無法直接作為參數傳回自己本身。
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
