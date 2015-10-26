package zcy04.recursion.dynamic;

import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_056 {

	public static String[] shortestPath(int[][] array) {
		if (array == null) {
			return null;
		}
		int m = array.length;
		if (m == 0) {
			return null;
		}
		int n = array[0].length;
		if (n == 0) {
			return null;
		}

		int[][] dp = new int[m][n];
		dp[0][0] = array[0][0];
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + array[i][0];
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + array[0][i];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + array[i][j];
			}
		}
		System.out.println("Length:" + dp[m - 1][n - 1]);
		String[] path = new String[m + n - 1];
		int k = path.length - 1;
		path[k--] = "(" + (m - 1) + "," + (n - 1) + ")=" + array[m - 1][n - 1];
		for (int i = m - 1, j = n - 1; i >= 0 && j >= 0 && (i + j) >= 1;) {
			if (i == 0) {
				path[k--] = "(" + (0) + "," + (j - 1) + ")=" + array[0][j - 1];
				j--;
			} else if (j == 0) {
				path[k--] = "(" + (i - 1) + "," + (0) + ")=" + array[i - 1][0];
				i--;
			} else if (i == 0) {
				path[k--] = "(" + (0) + "," + (j - 1) + ")=" + array[0][j - 1];
				j--;
			} else if (dp[i - 1][j] < dp[i][j - 1]) {
				path[k--] = "(" + (i - 1) + "," + (j) + ")=" + array[i - 1][j];
				i--;
			} else if (dp[i][j - 1] <= dp[i - 1][j]) {
				path[k--] = "(" + (i) + "," + (j - 1) + ")=" + array[i][j - 1];
				j--;
			}
		}

		return path;
	}

	public static void main(String[] args) {
		Random r = new Random();
		int M = 5;
		int N = 10;
		int[][] a1 = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				a1[i][j] = r.nextInt(20);
			}
		}
		CommonUtils.printArray(a1);
		String[] path = shortestPath(a1);
		CommonUtils.printArray(path);
	}

}
