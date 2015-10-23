package career09.recursion.dynamic;

public class Exam_9_1 {

	public static long getTotal(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}
		return getTotal(n - 1) + getTotal(n - 2) + getTotal(n - 3);
	}

	public static long getTotal2(int n) {
		if (n <= 0) {
			return 0L;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}
		long[] result = new long[n];
		result[0] = 1;
		result[1] = 2;
		result[2] = 4;

		for (int j = 3; j < n; j++) {
			result[j] = result[j - 1] + result[j - 2] + result[j - 3];
		}
		return result[n - 1];
	}

	public static long getTotal3(int n, long[] result) {
		if (n <= 0) {
			return 0L;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}
		result[0] = 1;
		result[1] = 2;
		result[2] = 4;
		if (result[n - 1] > 0) {
			return result[n - 1];
		}
		result[n - 1] = getTotal3(n - 1, result) + getTotal3(n - 2, result)
				+ getTotal3(n - 3, result);
		return result[n - 1];
	}

	public static void main(String[] args) {
		int N = 20;
		System.out.println();
		long t1 = System.currentTimeMillis();
		for (int i = 1; i <= N; i++) {
			System.out.print( getTotal(i) + ", ");
		}
		long t2 = System.currentTimeMillis();
		System.out.println("\nTime:" + (t2 - t1));

		t1 = System.currentTimeMillis();
		for (int i = 1; i <= N; i++) {
			System.out.print( getTotal2(i) + ", ");
		}
		t2 = System.currentTimeMillis();
		System.out.println("\nTime:" + (t2 - t1));

		t1 = System.currentTimeMillis();
		long[] result = new long[N];
		for (int i = 1; i <= N; i++) {
			System.out.print( getTotal3(i, result) + ", ");
		}
		t2 = System.currentTimeMillis();
		System.out.println("\nTime:" + (t2 - t1));
	}

}
