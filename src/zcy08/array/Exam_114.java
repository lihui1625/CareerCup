package zcy08.array;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_114 {

	public static void main(String[] args) {
		Random r = new Random();
		int M = 20;
		int[] a1 = new int[M];

		for (int i = 0; i < M; i++) {
			a1[i] = r.nextInt(6);
		}
		CommonUtils.printArray(a1);
		int[] res = getMaxLen(a1);
		CommonUtils.printArray(res);

	}

	private static int[] getMaxLen(int[] a) {
		if (a == null || a.length == 0) {
			return null;
		}
		int maxLen = 0;
		int start = -1;
		int end = -1;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			set.clear();
			for (int j = i; j < a.length; j++) {
				if (set.contains(a[j])) {
					break;
				}
				set.add(a[j]);
				min = Math.min(min, a[j]);
				max = Math.max(max, a[j]);
				if (max - min == j - i) {
					if (j - i > maxLen) {
						maxLen = j - i;
						start = i;
						end = j;
					}
				}

			} 
		}
		int[] res = new int[end - start + 1];
		for (int i = start, j = 0; i <= end; i++) {
			res[j++] = a[i];
		}
		return res;
	}
}
