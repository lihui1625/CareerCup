package zcy05.string;

public class Exam_085 {

	public static boolean isValid(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}

		int total = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ')' && s.charAt(i) != '(') {
				return false;
			} else if (s.charAt(i) == '(') {
				total++;
			} else if (s.charAt(i) == ')') {
				total--;
			}
		}
		return total == 0;
	}

	public static int maxValidleng(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}

		int[] dp = new int[s.length()];
		int maxLen = 0;
		dp[0] = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				int preIndex = i - 1 - dp[i - 1];
				if (preIndex >= 0 && s.charAt(preIndex) == '(') {
					if (preIndex == 0) {
						dp[i] = dp[i - 1] + 2;
					} else {
						dp[i] = dp[i - 1] + 2 + dp[preIndex - 1];
					}
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println(isValid("(()()())"));
		System.out.println(isValid("(()())())"));
		System.out.println(maxValidleng("((()()"));

	}

}
