package zcy04.recursion.dynamic;

import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_059 {

	public static int[] longestIncreasingSubsquence(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		int len = array.length;
		int[] dp = new int[len];
		int maxLen = 1;
		int endIndex = 0;
		for (int i = 0; i < len; i++) {
			dp[i] = 1;
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					if (maxLen < dp[i]) {
						maxLen = dp[i];
						endIndex = i;
					}
				}
			}
		}
		System.out.println("length: " + maxLen);
		int[] result = new int[maxLen];

		result[--maxLen] = array[endIndex];
		int lastIndex = endIndex; 
		for (int i=lastIndex-1;i >= 0; i--) {
			if (dp[i] + 1 == dp[lastIndex] && array[i] < array[lastIndex]) {
				result[--maxLen] = array[i];
				lastIndex = i; 
			} 
		}

		return result;
	}

	public static void main(String[] args) {
		Random r = new Random();
		int M = 20;
		int[] a1 = new int[M];

		for (int i = 0; i < M; i++) {
			a1[i] = r.nextInt(10) - 3;
		}
		//a1 =new int[] {2,1,5,3,6,4,8,9,7};
		CommonUtils.printArray(a1);
		int[] path = longestIncreasingSubsquence(a1);
		CommonUtils.printArray(path);

	}

}
