package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_77 {

	public static void main(String[] args) {
		Random r = new Random();
		int N = 10;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(r.nextInt(25)+1);

		}
		System.out.println(sb.toString());
		long re = numDecode(sb.toString());
		System.out.println(re);

	}

	private static long numDecode(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int len = s.length();
		long[] dp = new long[len + 1];
		dp[len] = 1;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) <= '0' || s.charAt(i) > '9') {
				dp[i] = 0;
			} else if (i < len - 1
					&& ((s.charAt(i) == '1') || (s.charAt(i) == '2' && (s
							.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6')))) {
				dp[i] = dp[i + 1] + dp[i + 2];
			} else {
				dp[i] = dp[i + 1];
			}
		}
		return dp[0];
	}

}
