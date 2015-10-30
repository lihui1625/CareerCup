package leetcode17.bit;

public class Exam_135 {

	public static int add(int a, int b){
		int sum = a^b;
		int carry = (a&b)<<1;
		while(carry>0){
			int tmp = sum;
			sum = sum^ carry;
			carry = (carry&tmp)<<1;
		}
		return sum;
		
	}
	
	public static void main(String[] args) {
		System.out.println(add(978,865));
		System.out.println(add(55879,76987));
		System.out.println(add(-100,878));
		System.out.println(add(-100,-878));
	}

}
