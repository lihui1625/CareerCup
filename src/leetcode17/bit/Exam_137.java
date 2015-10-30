package leetcode17.bit;

import java.util.LinkedList;
import java.util.List;

public class Exam_137 {

	public static List<Integer> climb(int n){
		List<Integer> resultList = new LinkedList<>();
		for(int i=0; i<32 && n>0; i++){
			if((n&1) ==1){
				resultList.add((int)Math.pow(2, i));
			}
			n = n>>1;
		}
		return resultList;
	}
	
	public static void main(String[] args) {
		System.out.println(climb(10000)); 
	}

}
