package zcy04.recursion.dynamic;

import java.util.Random;

public class Exam_063 {

 

	public static int editDistance(String s1, String s2, int ic, int dc, int rc) {

		int newRC = Math.min(dc + ic, rc);

		if (s1 == null && s2 == null) {
			return 0;
		}
		if (s1 == null || s1.length() == 0) {
			return s2.length() * ic;
		}
		if (s2 == null || s2.length() == 0) {
			return s1.length() * dc;
		}

		int len1 = s1.length();
		int len2 = s1.length();

		int[][] dp = new int[len1 + 1][len2 + 1];
		dp[0][0] = 0;

		for (int i = 1; i <= len1; i++) {
			dp[i][0] = i * ic;
		}
		for (int j = 1; j <= len2; j++) {
			dp[0][j] = j * dc;
		}

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int v1 = dp[i][j - 1] + 1 * ic;
					int v2 = dp[i - 1][j] + 1 * dc;
					int v3 = dp[i][j] + 1 * newRC;
					dp[i][j] = Math.min(Math.min(v1, v2), v3);
				}

			}
		}

		return dp[len1][len2];
	}

	public static void main(String[] args) {
		Random r = new Random();
		int M = 10;
		char[] a1 = new char[M];

		for (int i = 0; i < M; i++) {
			a1[i] = (char) (r.nextInt(4) + 'A');
		}

		int N = 10;
		char[] a2 = new char[N];

		for (int i = 0; i < N; i++) {
			a2[i] = (char) (r.nextInt(4) + 'A');
		}

		String s1 = (new String(a1));
		String s2 = (new String(a2));

		s1 = "AB";
		s2 = "12"; 
		System.out.println(s1);
		System.out.println(s2); 

		int result = editDistance(s1, s2 ,2,3,7);
		System.out.println(result);

	}

}
