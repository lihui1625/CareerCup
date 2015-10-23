package career01.array;

public class Exam_1_5 {

	public static String compress(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
 		int len = s.length();
		char[] resultArray = new char[len];
		int resultArrayIndex = 0;
		char nowChar = s.charAt(0);
		char nowCharCount = 1;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == nowChar) {
				nowCharCount++;
			}
			if (s.charAt(i) != nowChar || i == len - 1) {
				if (resultArrayIndex >= (len - 1) - 2) {
					return s;
				}
				resultArray[resultArrayIndex++] = nowChar;
				resultArray[resultArrayIndex++] = (char) ('0' + nowCharCount);
				nowChar = s.charAt(i);
				nowCharCount = 1;
			}
		}
		return new String(resultArray);
	}

	public static void main(String[] args) {
		System.out.println(compress("dddddddffffaaaaaavasddafsf"));
		System.out.println(compress("ddffaaavasddafsf"));
	}

}
