package zcy05.string;

public class Exam_076 {

	public static int str2Int(String s){
		try{
		return Integer.parseInt(s);
		}
		catch(Exception ex){
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(str2Int("100")); 
		System.out.println(str2Int("-100")); 
		System.out.println(str2Int("-0100")); 
		System.out.println(str2Int("-0x100")); 
		System.out.println(str2Int("-100l")); 
	}

}
