package leetcode11.dynamicprogram;

public class CommonUtils {

	public static void printArray(int[] a1) {
		if (a1 == null) {
			return;
		}
		int m = a1.length;
		if (m == 0) {
			return;
		}
		System.out.println();
		for (int i = 0; i < m; i++) {
			System.out.print(a1[i] + "\t ");
		}
		System.out.println();
	}

	public static void printArray(int[][] a1) {
		if (a1 == null) {
			return;
		}
		int m = a1.length;
		if (m == 0) {
			return;
		}
		int n = a1[0].length;
		System.out.println();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a1[i][j] + "\t ");
			}
			System.out.println();
		}
	}

	public static void printArray(Object[] a1) {
		if (a1 == null) {
			return;
		}
		int m = a1.length;
		if (m == 0) {
			return;
		}
		System.out.println();
		for (int i = 0; i < m; i++) {
			System.out.print(a1[i] + "\t ");
		}
		System.out.println();
	}

	public static void printArray(Object[][] a1) {
		if (a1 == null) {
			return;
		}
		int m = a1.length;
		if (m == 0) {
			return;
		}
		int n = a1[0].length;
		System.out.println();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a1[i][j] + "\t ");
			}
			System.out.println();
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
