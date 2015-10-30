package zcy08.array;

import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_122 {

	public static void main(String[] args) {
		Random r = new Random();
		int M = 20;
		int[] a1 = new int[M];

		for (int i = 0; i < M; i++) {
			a1[i] = r.nextInt(10) - 5;
		}
		CommonUtils.printArray(a1);
		int b = largesttSum(a1);
		System.out.println(b); 

	}

	private static int largesttSum(int[] a1) {
		if(a1==null || a1.length==0){
			return 0;
		}
		int curStart=0; 
		int maxStart=0;
		int maxEnd=0;
		int maxSum=a1[0];
		int curSum=0;
		int lastA1 = a1[0];
		for(int i=1;i<a1.length;i++){
		 
			curSum += a1[i];
			if(curSum>maxSum){
				maxSum =  curSum ; 
				maxStart = curStart;
				maxEnd = i;
			}  
			if(curSum<0){
				curSum = 0;
				curStart = i+1;
			} 
			lastA1 = a1[i];
		} 
		return maxSum;
	}
}
