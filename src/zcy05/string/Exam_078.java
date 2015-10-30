package zcy05.string;

public class Exam_078 {

	public static String contStr(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		StringBuilder sb = new StringBuilder();

		char start = s.charAt(0);
		int ct = 1;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == start) {
				ct++;
			} else  {
				sb.append(start).append("_").append(ct).append("_");
				start = c;
				ct = 1;
			}
			if (i == s.length() - 1) {
				sb.append(c).append("_").append(ct);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(contStr("aaadddcccsdfasdfdssddsafasweweweeeefffa"));

	}

}
