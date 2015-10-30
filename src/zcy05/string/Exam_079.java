package zcy05.string;

import java.util.HashSet;
import java.util.Set;

public class Exam_079 {
	
	public static boolean onlyOne(String s){
		if(s==null || s.isEmpty()){
			return true;
		}
		Set<Character> set = new HashSet<>();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(set.contains(c)){
				return false;
				
			}
			else{
				set.add(c);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(onlyOne("aaa"));
		System.out.println(onlyOne("abc"));
		System.out.println(onlyOne("aba"));
	}

}
