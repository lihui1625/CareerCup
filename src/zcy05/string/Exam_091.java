package zcy05.string;

public class Exam_091 {

	public int minLen(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() < s2.length()) {
			return 0;
		}
		int[] map = new int[256];
		for (int i = 0; i < s2.length(); i++) {
			map[s2.charAt(i)]++;
		}

		int left = 0;
		int right = 0;
		int match = s2.length();
		int minLen = Integer.MAX_VALUE;

		while (right < s1.length()) {
			map[s1.charAt(right)]--;
			if (map[s1.charAt(right)] >= 0) {
				match--;
			}
			if (match == 0) {
				while (map[s1.charAt(left)] < 0) {
					map[s1.charAt(left++)]++;
				}
				minLen = Math.min(minLen, right - left + 1);
				match++;
				map[s1.charAt(left)]++;
			}

			right++;
		}
		return minLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
