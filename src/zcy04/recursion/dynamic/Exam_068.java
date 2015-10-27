package zcy04.recursion.dynamic;

import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_068 {

	public static void main(String[] args) {
		Random r = new Random();
		int M = 20;
		int[] a1 = new int[M];

		for (int i = 0; i < M; i++) {
			a1[i] = r.nextInt(20);
		}
		// a1 =new int[] {2,1,5,3,6,4,8,9,7};
		CommonUtils.printArray(a1);
		int score = maxScore(a1);
		System.out.println(score);

	}

	private static int maxScore(int[] a1) {
		if (a1 == null || a1.length == 0) {
			return 0;
		}

		int len = a1.length;
		int[][] f = new int[len][len];
		int[][] s = new int[len][len];

		

		for (int j = 0; j < len; j++) {
			f[j][j] = a1[j];
			for (int i = j - 1; i >= 0; i--) {
				f[i][j] = Math.max(a1[i] + s[i + 1][j], a1[j] + s[i][j - 1]);
				s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
			}
		}

		return Math.max(f[0][len - 1], s[0][len - 1]);
	}

}
