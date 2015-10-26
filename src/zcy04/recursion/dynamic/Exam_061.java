package zcy04.recursion.dynamic;

import java.util.Random;

public class Exam_061 {

	public static String longestCommonSubquence(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return null;
		}
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 == 0 || len2 == 0) {
			return "";
		}
		int[][] dp = new int[len1][len2];
		dp[0][0] = (s1.charAt(0) == s2.charAt(0) ? 1 : 0);
		for (int i = 1; i < len2; i++) {
			dp[0][i] = Math.max(dp[0][i-1], (s1.charAt(0) == s2.charAt(i) ? 1 : 0));
		}
		for (int i = 1; i < len1; i++) {
			dp[i][0] = Math.max(dp[i-1][0], (s1.charAt(i) == s2.charAt(0) ? 1 : 0));
		}

		 
		for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {
				int lastLongerDp = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (s1.charAt(i) == s2.charAt(j)
						&& dp[i - 1][j - 1] + 1 > lastLongerDp) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					

				} else {
					dp[i][j] = lastLongerDp;
				}
			}
		}
		int commonSize = dp[len1 - 1][len2 - 1];
		System.out.println("length: " + commonSize);
		if (commonSize == 0) {
			return "";
		}
		char[] commonChar = new char[commonSize];

		int endX = len1-1;
		int endY = len2-1;
		while (commonSize>0) {
			if (endX > 0 && dp[endX - 1][endY] == dp[endX][endY]) {
				endX--;
			} else if (endY > 0 && dp[endX][endY - 1] == dp[endX][endY]) {
				endY--;
			}
			else {
				commonChar[--commonSize] = s1.charAt(endX);
				endX--;
				endY--;
			}
		}

		return new String(commonChar);
	}

	public static void main(String[] args) {
		Random r = new Random();
		int M = 50;
		char[] a1 = new char[M];

		for (int i = 0; i < M; i++) {
			a1[i] = (char) (r.nextInt(20) + 'A');
		}

		int N = 30;
		char[] a2 = new char[N];

		for (int i = 0; i < N; i++) {
			a2[i] = (char) (r.nextInt(20) + 'A');
		}
		String s1 = (new String(a1));
		String s2 = (new String(a2));
		
	 

		System.out.println(s1);
		System.out.println(s2);
		String result = longestCommonSubquence(s1, s2);
		System.out.println(result);

	}

}
