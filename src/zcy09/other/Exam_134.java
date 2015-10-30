package zcy09.other;

public class Exam_134 {

	public static int greatestCommonNumber(int m, int n) {
		if (n == 0) {
			return m;
		}
		return greatestCommonNumber(n, m % n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
