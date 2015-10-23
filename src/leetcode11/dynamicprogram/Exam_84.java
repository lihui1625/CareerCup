package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_84 {

	public static void main(String[] args) {
		Random r = new Random();
		int N = 50;

		StringBuilder s1 = new StringBuilder();
		for (int i = 0; i < N; i++) {
			s1.append((char) (r.nextInt(5) + 'a'));

		}
		System.out.println(s1.toString());

		StringBuilder s2 = new StringBuilder();
		for (int i = 0; i < N; i++) {
			s2.append((char) (r.nextInt(5) + 'a'));

		}
		System.out.println(s2.toString());

		System.out.println(isScramble(s1.toString(), s2.toString()));
		
		System.out.println(isScramble(s2.toString(), s2.toString()));

	}

	private static boolean isScramble(String s1, String s2) {

		if (s1 == null || s2 == null) {
			return false;
		}
		int len = s1.length();
		if (s2.length() != len) {
			return false;
		}

		boolean dp[][][] = new boolean[len][len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				dp[i][j][0] = s1.charAt(i) == s2.charAt(j);
			}
		}

		for (int l = 0; l < len; l++) {
			for (int i = 0; i + l < len; i++) {
				for (int j = 0; j + l < len; j++) {
					for (int k = 0; k < l; k++) {
						if ((dp[i][j][k] && dp[i + k + 1][j + k + 1][l - k - 1])
								|| (dp[i][j + l - k][k] && dp[i + k + 1][j][l
										- k - 1])) {
							dp[i][j][l] = true;
							break;
						}
					}
				}
			}
		}
		return dp[0][0][len - 1];
	}

}
