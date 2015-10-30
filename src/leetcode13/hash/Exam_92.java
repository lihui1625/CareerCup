package leetcode13.hash;

import java.util.HashMap;

public class Exam_92 {

	public static int longestContinuesSubSquence(int[] a){
		HashMap<Integer,Integer> map = new HashMap<>();
		int max = 1;
		for(int i:a){
			if(map.containsKey(i)){
			   continue;
			} 
			map.put(i, 1);	
			if(map.containsKey(i-1)){
				max = Math.max(max, merge(map,i-1,i));
			}
			if(map.containsKey(i+1)){
				max = Math.max(max, merge(map,i,i+1));
			}
		}
		return max;
	}
	
	
	private static int merge(HashMap<Integer,Integer> map, int left, int right){
		int upper = right + map.get(right)-1;
		int lower = left - map.get(left) +1;
		int len = upper - lower +1;
		for(int i=lower;i<=upper;i++){
			map.put(i, len);
		} 
		return len;
	}
	
	public static void main(String[] args) {
		int[] a = {8,1,9,3,2,4};
		System.out.println(longestContinuesSubSquence(a));

	}

}
