package leetcode16.math;

public class Exam_122 {

	public static int fibonacci(int i) {
		if (i <= 0) {
			return 0;
		}
		if (i == 1 || i == 2) {
			return 1;
		}
		int last1 = 1;
		int last2 = 1;
		int result = 0;
		for (int j = 3; j <= i; j++) {
			result = last1 + last2;
			last2 = last1;
			last1 = result;
		}
		return result;
	}

	public static void main(String[] args) {
		for(int i=1;i<10;i++){
			System.out.println(fibonacci(i));
		}

	}

}
