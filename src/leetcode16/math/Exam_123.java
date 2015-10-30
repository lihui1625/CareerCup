package leetcode16.math;

public class Exam_123 {

	public static double power(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 1/positivePower(x, -n);
		} else {
			return positivePower(x, n);
		}
	}

	private static double positivePower(double x, int n) {

		if (n < 0) {
			throw new RuntimeException("not supported");
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if (n % 2 == 0) {
			double half = power(x, n / 2);
			return half * half;
		} else {
			double half = power(x, n / 2);
			return half * half * x;
		}
	}

	public static void main(String[] args) {
		System.out.println(power(2,1));
		System.out.println(power(2,2));
		System.out.println(power(2,3));
		System.out.println(power(2,4));
		System.out.println(power(2,5));
		System.out.println(power(2,-1));
		System.out.println(power(2,-2));
		System.out.println(power(2,-3));
		System.out.println(power(2,-4));
		System.out.println(power(2,-5));

	}

}
