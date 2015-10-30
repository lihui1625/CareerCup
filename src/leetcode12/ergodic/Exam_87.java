package leetcode12.ergodic;

import java.util.Arrays;
import java.util.Random;

public class Exam_87 {

	public static void fill0to1(int[][] image) {
		int m = image.length;
		int n = image[0].length;
		boolean[][] remain = new boolean[m][n];
		for (int i = 0; i < n; i++) {
			if (image[0][i] == 0 && !remain[0][i]) {
				dfs(image, remain, 0, i);
			}
			if (image[m - 1][i] == 0 && !remain[m - 1][i]) {
				dfs(image, remain, m - 1, i);
			}
		}
		for (int i = 0; i < m; i++) {
			if (image[i][0] == 0 && !remain[i][0]) {
				dfs(image, remain, i, 0);
			}
			if (image[i][n - 1] == 0 && !remain[i][n - 1]) {
				dfs(image, remain, i, n - 1);
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(!remain[i][j] && image[i][j] == 0){
					image[i][j] = 8;
				}
			}
		}
	}

	private static void dfs(int[][] image, boolean[][] remain, int x, int y) {
		if (x < 0 || y < 0 || x >= image.length || y >= image[0].length) {
			return;
		}
		if (image[x][y] != 0 || remain[x][y]) {
			return;
		}
		remain[x][y] = true;
		dfs(image, remain, x - 1, y);
		dfs(image, remain, x + 1, y);
		dfs(image, remain, x, y - 1);
		dfs(image, remain, x, y + 1);

	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 10;
		int[][] im = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				im[i][j] = r.nextInt(3)*r.nextInt(3);
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(im[i]));

		}
		System.out.println("--------------------");
		fill0to1(im) ;
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(im[i]));

		}
	}

}
