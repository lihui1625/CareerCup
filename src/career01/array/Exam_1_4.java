package career01.array;

public class Exam_1_4 {

	public static String replaceSpace(String s) {
		if (s == null) {
			return null;
		}
		if (s.length() == 0) {
			return s;
		}
		int spaceCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				spaceCount ++;
			} 
		}
		char[] result = new char[s.length() + 2*spaceCount];
		for(int i=0, j=0; i < s.length(); i++)
		{
			if (s.charAt(i) == ' ') {
				result[j++] = '%';
				result[j++] = '2';
				result[j++] = '0';
			} else {
				result[j++] = s.charAt(i);
			}
		}

		return new String(result);
	}

	public static void main(String[] args) {
		 
		System.out.println(replaceSpace("bvgh,  vbhg xzc MN Mr MKSD MDds fasd  "));
	}

}
