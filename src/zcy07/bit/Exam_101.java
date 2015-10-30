package zcy07.bit;

public class Exam_101 {

	public static void swap1() {
		int a = 111;
		int b = 999;
		System.out.println(a + "," + b);
		a = a+b;
		b = a -b;
		a = a- b;
		System.out.println(a + "," + b); 
	}
	
	public static void swap2() {
		int a = 111;
		int b = 999;
		System.out.println(a + "," + b);
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println(a + "," + b); 
	}

	public static void main(String[] args) {
		swap1();
		swap2();

	}

}
