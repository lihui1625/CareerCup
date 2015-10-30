package zcy08.array;

import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_111 {

	public static void main(String[] args) {
		Random r = new Random();
		int M = 20;
		int[] a1 = new int[M];

		for (int i = 0; i < M; i++) {
			a1[i] = r.nextInt(10)+3*i;
		}
		CommonUtils.printArray(a1);
		int[] res = needSort(a1);
		CommonUtils.printArray(res);

	}

	private static int[] needSort(int[] a1) {
		if (a1 == null || a1.length < 2) {
			return null;
		}
		int min = a1[a1.length - 1];
		int noMinIndex = -1;

		 for (int i = a1.length - 1; i >= 0; i--) {
			if (a1[i] >  min) {
				noMinIndex = i;
			} else {
				min = a1[i];
			}
		}
		 
		 if (noMinIndex == -1) {
			return null;
		}
		
		int max = a1[0] ;
		int noMaxIndex = -1;

		for (int i = 0; i < a1.length; i++) {
			if (a1[i] <  max) {
				noMaxIndex = i;
			} else {
				max = a1[i];
			}
		}  
		if (noMaxIndex == -1) {
			return null;
		}
		if (noMaxIndex < noMinIndex) {
			return null;
		}
		
		int[] res = new int[noMaxIndex - noMinIndex + 1];
		for (int i = noMinIndex, j = 0; i <= noMaxIndex; i++) {
			res[j++] = a1[i];
		}

		return res;
	}
}
