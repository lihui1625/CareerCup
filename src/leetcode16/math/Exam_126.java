package leetcode16.math;

import java.util.Random;

public class Exam_126 {

	static Random r = new Random();

	public static boolean isKnown(String[] str, int a, int b) {
		if (a == b) {
			throw new RuntimeException("error");
		}
		if (str[a].equals("star")) {
			return false;
		}
		if (str[b].equals("star")) {
			return true;
		}
		return r.nextInt(1) > 0; // s
	}

	public static int findStarIndex(String[] str) {
		int start = 0;
		int end = str.length - 1;
		while (start < end) {
			if (isKnown(str, start, end)) {
				start++;
			} else {
				end--;
			}
		}

		boolean isFound = true;
		for (int k = 0; k < str.length; k++) {
			if (isFound && k != end
					&& (!isKnown(str, k, end) || isKnown(str, end, k))) {
				isFound = false;
			}
		}
		if (isFound) {
			return end;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		String[] str = { "a", "c", "v", "start", "w", "x","star", "e","e", "w" };
		System.out.println(findStarIndex(str));

	}

}
