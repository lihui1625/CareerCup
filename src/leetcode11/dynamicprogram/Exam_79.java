package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_79 {

	public static void main(String[] args) {
		Random r = new Random();
		int N = 5;

		StringBuilder s = new StringBuilder();
		for (int i = 0; i < 2 + N; i++) {
			s.append((char) (r.nextInt(4) + 'a'));

		}
		System.out.println(s.toString());

		StringBuilder t = new StringBuilder();
		for (int i = 0; i < N; i++) {
			t.append((char) (r.nextInt(4) + 'a'));
		}
		System.out.println(t.toString());

		int editDistance = editDistance(s.toString(), t.toString());
		System.out.println(editDistance);

	}

	private static int editDistance(String s, String t) {
		int lenS = s == null ? 0 : s.length();
		int lenT = t == null ? 0 : t.length();
		if (lenS == 0) {
			return lenT;
		}
		if (lenT == 0) {
			return lenS;
		}
		int[][] dp = new int[lenS + 1][lenT + 1];
		for (int i = 0; i <= lenS; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= lenT; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= lenS; i++) {
			for (int j = 1; j <= lenT; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
							Math.min(dp[i][j - 1], dp[i - 1][j]));
				}

			}
		}
		return dp[lenS][lenT];
	}

}
