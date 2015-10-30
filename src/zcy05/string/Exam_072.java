package zcy05.string;

import java.util.HashMap;
import java.util.Map;

public class Exam_072 {

	public static boolean isDeform(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.length() != s2.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (map.containsKey(c)) {
				int count = map.get(c);
				if (count > 1) {
					map.put(c, count - 1);
				} else {
					map.remove(c);
				}

			} else {
				return false;
			}
		}
		return map.isEmpty();

	}

	public static void main(String[] args) {
		System.out.println(isDeform("123","213") );
		System.out.println(isDeform("1231","213") );
		System.out.println(isDeform("123","2131") );
		System.out.println(isDeform("发送到","到送发") );
		System.out.println(isDeform("发送到","到送额") );

	}

}
