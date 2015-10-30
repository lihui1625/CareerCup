package zcy05.string;

import java.util.LinkedList;
import java.util.List;

public class Exam_073 {

	public static int sumNo(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int sum = 0;

		List<String> list = new LinkedList<>();
		StringBuilder sb = null;
		char last = 'a';
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur >= '0' && cur <= '9') {
				if (sb == null) {
					sb = new StringBuilder();
				}
				sb.append(cur);
			}
			else if (cur == '-') {
				if (sb == null) {
					sb = new StringBuilder();
					sb.append(cur);
				} else if (last=='-' && !sb.toString().isEmpty()) {
					sb.deleteCharAt(sb.length()-1);
				} else if (last >= '0' && last <= '9') {
					list.add(sb.toString());
					sb = new StringBuilder();
					sb.append(cur);
				}else{
					sb.append(cur);
				}
			} 
			else if (i < s.length() - 1 
					&& sb != null 
					&& !sb.toString().isEmpty()  
					&& !sb.toString().equals("-")) {
				list.add(sb.toString());
				sb = null;
			}
			last = cur;
			if (i == s.length() - 1 
					&& sb != null 
					&& !sb.toString().isEmpty()  
					&& !sb.toString().equals("-")) {
				list.add(sb.toString());
				break;
			}
		}
		for(String s2 :list){
			System.out.println(s2);
			sum += Integer.parseInt(s2);
		}
		return sum;

	}

	public static void main(String[] args) {
		System.out.println(sumNo("12a1.2sdf234dasd-2---31-423--"));

	}

}
