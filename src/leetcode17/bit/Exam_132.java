package leetcode17.bit;

public class Exam_132 {

	public static boolean isPowerOf2(int n){
		if(n<=0){
			return false;
		}
		return (n&(n-1))==0;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOf2(-1));
		System.out.println(isPowerOf2(0));
		System.out.println(isPowerOf2(1));
		System.out.println(isPowerOf2(2));
		System.out.println(isPowerOf2(3));
		System.out.println(isPowerOf2(4));
		System.out.println(isPowerOf2(5));
		System.out.println(isPowerOf2(16));
		System.out.println(isPowerOf2(33));

	}

}
