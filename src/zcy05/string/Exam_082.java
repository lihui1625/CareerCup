package zcy05.string;

public class Exam_082 {

	public static String fz1(String s, int k) {
		if (s == null || s.isEmpty() || k <= 0 || k > s.length()) {
			return s;
		}

		char[] array = s.toCharArray();
		int len = array.length ;
		reverse(array, 0, len- 1);
		reverse(array, len-1 - k + 1, len-1);
		reverse(array, 0, len-1 - k);

		return String.valueOf(array);
	}

	public static String fz2(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}

		char[] array = s.toCharArray();
		int len = array.length ;
		reverse(array, 0, len-1);
		int start = -1;
		int end = -1;
		for (int i = 0; i <  len; i++) {
			if (array[i] != ' ') {
				if (start == -1) {
					start = i;
				}
				end = i;
				if (i == len - 1) {
					reverse(array, start, end);
				}
			} else {
				if (start > -1) {
					reverse(array, start, end);
					start = -1;
				}
			}
		}
		return String.valueOf(array);
	}

	private static void reverse(char[] a, int start, int end) {
		if (start < 0 || end > a.length - 1) {
			return;
		}
		while (start < end) {
			char tmp = a[start];
			a[start] = a[end];
			a[end] = tmp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		String s = "1234567890";
		System.out.println(s);
		System.out.println(fz1(s, 3));

		s = "we love china";
		System.out.println(s);
		System.out.println(fz2(s));

	}

}
