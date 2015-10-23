package leetcode11.dynamicprogram;


import java.util.Random;

public class Exam_72 {

	public static int minPath(int[][] a) {
		int m = a.length;
		if (m == 0) {
			return 0;
		}
		int n = a[0].length;
		if (n == 0) {
			return 0;
		}
		int[][] path = new int[m][n];
		path[0][0] = a[0][0];
		for (int i = 1; i < m; i++) {
			path[0][i] = path[0][i - 1] + a[0][i];
		}
		for (int i = 1; i < n; i++) {
			path[i][0] = path[i - 1][0] + a[i][0];
		} 

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (path[i - 1][j] > path[i][j - 1]) { 
					path[i][j] = path[i][j - 1] + a[i][j];
				} else { 
					path[i][j] = path[i - 1][j] + a[i][j];
				}
			}
		}

		return path[m-1][n-1];

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
		int re = minPath(a1);
		System.out.println(re);
	}

}
