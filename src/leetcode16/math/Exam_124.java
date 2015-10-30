package leetcode16.math;

public class Exam_124 {

	public static int sqrt(int n) {
		if (n < 0) {
			throw new RuntimeException(" n>=0 ");
		}
		return sqrt(n, 0, n);
	}

	private static int sqrt(int n, int s, int e) {
		if (s >= e) {
			return n - s * s < e * e - n ? s : e;
		}
		int mid = (s + e) / 2;
		if (mid * mid > n) {
			return sqrt(n, s, mid - 1);
		} else if (mid * mid < n) {
			return sqrt(n, mid + 1, e);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		//System.out.println(sqrt(0));
		//System.out.println(sqrt(100));
		//System.out.println(sqrt(1000));
		System.out.println(sqrt(200));
		//System.out.println(sqrt(2000));

	}

}
