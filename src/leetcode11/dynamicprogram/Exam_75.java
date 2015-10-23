package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_75 {

	public static int pathCount(int[][] a) {
		int m = a.length;
		if (m == 0) {
			return 0;
		}
		int n = a[0].length;
		if (n == 0) {
			return 0;
		}
		int[] dp = new int[n];
		for (int i = 1; i < n; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j - 1];
			}
		}

		return dp[n - 1];

	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 10;
		int[][] a1 = new int[N][N];
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a1[i][j] = r.nextInt(10);
				System.out.print(a1[i][j] + "\t ");
			}
			System.out.println();
		}
		int re = pathCount(a1);
		System.out.println(re);
	}

}
