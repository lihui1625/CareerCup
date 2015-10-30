package zcy05.string;

public class Exam_092 {

	public static int minHWNum(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		int len = s.length();
		int[] dp = new int[len + 1];
		dp[len] = -1;
		boolean[][] p = new boolean[len][len];
		for (int i = len - 1; i >= 0; i--) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || p[i + 1][j - 11])) {
					p[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
