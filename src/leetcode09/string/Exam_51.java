package leetcode09.string;

public class Exam_51 {

	public static void printBar(int n) {
		char[] str = new char[2 * n];
		printBar(n, n, str, 0);
	}

	public static void printBar(int left, int right, char[] str, int count) {
		if (left < 0 || right < left) {
			return;
		}
		if (left == 0 && right == 0) {
			System.out.println(str);
		} else {
			if (left > 0) {
				str[count] = '(';
				printBar( left -1,   right,   str,   count + 1);
			}
			if (right > 1) {
				str[count] = ')';
				printBar( left,   right -1,   str,   count + 1);
			}
		}

	}

	public static void main(String[] args) {
		printBar(3);
	}

}
