package zcy05.string;

public class Exam_075 {
	
	public static boolean  isXZ(String s1, String s2){
		if(s1==null || s2==null || s1.length()!=s2.length()){
			return false;
		}
		
		String s3 = s1+s1;
		return s3.contains(s2);
		
	}

	public static void main(String[] args) {
		System.out.println(isXZ("abcd","bcda"));
		System.out.println(isXZ("abcd","bcad"));

	}

}
