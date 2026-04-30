package javap;

public class Test1 {

	public void test() {
		
		int a=0;
		System.out.println(a);
	}
	
	public int test1() {
		
		int b=0;
		System.out.println(b);
		return b;
		
	}
	
	public String test2()
	{
		String a= "hello";
		return a;
	}
	
	public static void main(String[] args) {
		
		Test1 t = new Test1();
		 t.test();
		t.test1();
		t.test2();
	}
}
