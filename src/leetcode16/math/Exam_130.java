package leetcode16.math;

import java.util.Arrays;

public class Exam_130 {
	
	public static long[] multyple(int[] a){
		long[] b = new long[a.length];
		long s = 1;
		for(int e: a){
			s *= e;
		}
		for(int i=0;i<a.length;i++){
			b[i] =  (s/a[i]);
		}
		return b;
	}

	public static void main(String[] args) {
		int[] a = {12,423,6,44,89,45,45,53,345,6,344,325,8,6,67,54,8,87,57,63,34,5,654,54};
		System.out.println(Arrays.toString(multyple(a)));

	}

}
