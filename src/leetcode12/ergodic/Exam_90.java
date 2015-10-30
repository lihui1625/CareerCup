package leetcode12.ergodic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Exam_90 {

	public static void genStringByRule(String s,
			HashMap<Character, List<Character>> map) {
		HashSet<String> set = new HashSet<>();
		set.add(s);
		getStringByRule(s, map, 0, set, "");
	}

	private static void getStringByRule(String s,
			HashMap<Character, List<Character>> map, int start,
			HashSet<String> set, String op) {
		if (start == s.length()) {
			if (!set.contains(op)) {
				System.out.println(op);
				set.add(op);
			}
			return;
		}

		List<Character> mutations = map.get(s.charAt(start));
		if (mutations != null) {
			for (Character c : mutations) {
				if (c != null) {
					getStringByRule(s, map, start + 1, set, op + c);
				}
			}
		}
		getStringByRule(s, map, start + 1, set, op + s.charAt(start));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
