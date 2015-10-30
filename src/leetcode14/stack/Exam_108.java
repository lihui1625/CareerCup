package leetcode14.stack;

import java.util.Stack;

public class Exam_108 {

	public static boolean isValidBracketValid(String s){
		Stack<Character> stack = new Stack<>();
		for(char c: s.toCharArray()){
			if(stack.isEmpty()){
				stack.push(c);
				continue;
			}
			if( (c==')'  && stack.peek()=='(')
			      || (c==']'  && stack.peek()=='[')
			      || (c=='}'  && stack.peek()=='{')){
				stack.pop();
			}else
			{
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s = "[][{()}]";
		System.out.println(isValidBracketValid(s));
		String s2 = "[][{(})]";
		System.out.println(isValidBracketValid(s2));
		String s3 = "[][{}()]";
		System.out.println(isValidBracketValid(s3));

	}

}
