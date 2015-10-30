package leetcode13.hash;

import java.util.HashMap;

public class Exam_94 {

	public static String lengthOfSubStr(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		HashMap<Character, Integer> map = new HashMap<>();
		int start = 0;
		int maxLen = 0;
		int maxStart = 0;
		int maxEnd = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c) && map.get(c) >= start) {
				start = i;
			}
			map.put(c, i);
			if (i - start + 1 > maxLen) {
				maxLen = i - start + 1;
				maxStart = start;
				maxEnd = i;
			}
		}

		return s.substring(maxStart, maxEnd + 1);
	}

	public static void main(String[] args) {
		System.out.println(lengthOfSubStr("fasfdweefsdvasdfrweaerwxvcadssdf"));
	}

}
