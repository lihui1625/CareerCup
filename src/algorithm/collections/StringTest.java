package algorithm.collections;

public class StringTest {

	public static void main(String[] args) {
		String s1 = new String("asdfgsfgewegsdffsa");
		String s2 = "asdfgsfgewegsdffsa";
		String s3 = new String("asdfgsfgewegsdffsa");
		
		boolean b = s1.equals(s3);
		String sub = s1.substring(2);
		String sub2 =s1.substring(3, 5);
		int indecx = s1.indexOf('d');
		char c = s1.charAt(5);
		int len = s1.length();
		int cp = s1.codePointAt(5);
		int cpb = s1.codePointBefore(5);
		int cpc = s1.codePointCount(6, 7);
		int ct = s1.compareTo("asfdad");
		int cti = s1.compareToIgnoreCase("ADAS");
		String newStr = s1.concat("213213"); 

	}

}
