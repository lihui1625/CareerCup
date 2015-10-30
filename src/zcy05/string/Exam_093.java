package zcy05.string;

public class Exam_093 {

	public static boolean isValid(String s, String exp) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		if (exp == null || exp.isEmpty()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*' || s.charAt(i) == '.') {
				return false;
			}
		}
		if (exp.charAt(0) == '*') {
			return false;
		}
		for (int i = 1; i < exp.length(); i++) {
			if (exp.charAt(i) == '*' || exp.charAt(i - 1) == '.') {
				return false;
			}
		}
		return true;
	}

	public static boolean isMatch(String s, String exp) {
		if (!isValid(s, exp)) {
			return false;
		}

		int sLen = s.length();
		int expLen = exp.length();

		boolean[][] dp = new boolean[sLen + 1][expLen + 1];
		dp[sLen][expLen] = true;
		for (int j = expLen - 2; j > -1; j = j - 2) {
			if (exp.charAt(j) != '*' && exp.charAt(j + 1) != '*') {
				dp[sLen][j] = true;
			} else {
				break;
			}
		}
		if (sLen > 0 && expLen > 0) {
			if (exp.charAt(expLen - 1) == '.'
					|| s.charAt(sLen - 1) == exp.charAt(expLen - 1)) {
				dp[sLen - 1][expLen - 1] = true;
			}
		}

		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = exp.length() - 2; j >= 0; j--) {
				if (exp.charAt(j + 1) == '*') {
					dp[i][j] = (dp[i + 1][j + 1]
							&& s.charAt(i) == exp.charAt(j) || exp.charAt(j) == '.');
				} else {
					int si = i;
					while(si!=s.length() && 
							(s.charAt(si)==exp.charAt(j) || exp.charAt(j)=='.')){
						if(dp[si][j+2]){
							dp[i][j] = true;
							break;
						}
						si++;
					}
					if(!dp[i][j]){
						dp[i][j] = dp[si][j+2];
					}

				}
			}
		}
		return dp[0][0];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
