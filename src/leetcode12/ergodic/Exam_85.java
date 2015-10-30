package leetcode12.ergodic;

import java.util.Arrays;
import java.util.Random;

public class Exam_85 {

	public static void fillColor(int[][] image, int newColor, int x, int y) {
		int m = image.length;
		int n = image[0].length;

		if (x < 0 || x >= m || y < 0 || y >= n) {
			return;
		}

		int oldColor = image[x][y];
		if (oldColor == newColor) {
			return;
		}
		image[x][y] = newColor;
		fillColor(image, newColor, x - 1, y);
		fillColor(image, newColor, x + 1, y);
		fillColor(image, newColor, x, y - 1);
		fillColor(image, newColor, x, y + 1);

	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 10;
		int[][] im = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				im[i][j] = r.nextInt(2)*r.nextInt(2);
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(im[i]));

		}
		System.out.println("--------------------");
		fillColor(im,im[0][0]==0?1:0, 0, 0) ;
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(im[i]));

		}

	}

}
