package leetcode14.stack;

import java.util.Stack;

public class Exam_109 {
	public static String longestBracketValid(String s) {
		int maxLen = 0;
		Stack<Integer> stack = new Stack<>();
		int left = 0;
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else if (c == ')') {
				if (stack.isEmpty()) {
					left = i + 1;
				} else {
					stack.pop();
					int thisLen = 0;
					if (stack.empty()) {
						thisLen = i - left + 1;
					} else {
						thisLen = i - stack.peek();
					}
					if (thisLen > maxLen) {
						maxLen = thisLen;
						result = s.substring(i + 1 - maxLen, i + 1);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "())(()())((";
		System.out.println(longestBracketValid(s));

	}
}
