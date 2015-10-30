package leetcode14.stack;

import java.util.Stack;

public class Exam_106 {

	public static String genRPNotation(String[] input) {
		if (input == null || input.length == 0) {
			return "";
		}
		String result = new String();
		Stack<String> stack = new Stack<>();
		for (String c : input) {
			if (c.equals("+") || c.equals("-") || c.equals("*")
					|| c.equals("/") || c.equals("&") || c.equals("&&")
					|| c.equals("^") || c.equals("||")) {
				if (result.isEmpty()) {
					result += stack.pop();
				}
				result = "(" + stack.pop() + c + result + ")";

			} else {
				stack.push(c);
			}
		}

		return result;
	}

	public static double genRPResult(String[] input) {
		if (input == null || input.length == 0) {
			return 0;
		}
		double result = 0;
		Stack<String> stack = new Stack<>();
		boolean isFirst = true;
		for (String c : input) {
			if (c.equals("+") || c.equals("-") || c.equals("*")
					|| c.equals("/") || c.equals("&") || c.equals("^")
					|| c.equals("|")) {
				if (isFirst) {
					isFirst = false;
					result = Double.parseDouble(stack.pop());
				}
				if (c.equals("+"))
					result = Double.parseDouble(stack.pop()) + result;
				if (c.equals("-"))
					result = Double.parseDouble(stack.pop()) - result;
				if (c.equals("*"))
					result = Double.parseDouble(stack.pop()) * result;
				if (c.equals("/"))
					result = Double.parseDouble(stack.pop()) / result;
				if (c.equals("&"))
					result = (int) Double.parseDouble(stack.pop())
							& (int) result;
				if (c.equals("|"))
					result = (int) Double.parseDouble(stack.pop())
							| (int) result;
				if (c.equals("^"))
					result = (int) Double.parseDouble(stack.pop())
							^ (int) result;

			} else {
				stack.push(c);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String[] a = { "1.1", "5.5", "2.7", "3.6", "+", "*", "+" };
		System.out.println(genRPNotation(a));
		System.out.println(genRPResult(a));

		String[] b = { "2.7", "3.6", "+", "1.1", "5.5", "*", "+" };
		System.out.println(genRPNotation(b));
		System.out.println(genRPResult(a));

	}

}
