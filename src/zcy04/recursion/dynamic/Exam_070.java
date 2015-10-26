package zcy04.recursion.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_070 {

	public static void main(String[] args) {
		Random r = new Random();
		int M = 20;
		int[] a1 = new int[M];

		for (int i = 0; i < M; i++) {
			a1[i] = r.nextInt(10);
		}
		// a1 =new int[] {2,1,5,3,6,4,8,9,7};
		CommonUtils.printArray(a1);
		int[] path = longestContinuousSubsquence(a1);
		CommonUtils.printArray(path);
		int[] path2 = longestContinuousSubsquence2(a1);
		CommonUtils.printArray(path2);

	}

	private static int[] longestContinuousSubsquence(int[] a1) {
		if (a1 == null || a1.length == 0) {
			return a1;
		}
		int[] a1Copy = Arrays.copyOf(a1, a1.length);

		Arrays.sort(a1Copy);
		CommonUtils.printArray(a1Copy);

		int start = 0;
		int maxLen = 0;

		for (int i = 0; i < a1.length; i++) {
			int thisStart = i;
			int thisLen = 1;
			for (int j = i + 1; j < a1.length; i++, j = i + 1) {
				if (a1Copy[j] == a1Copy[i] + 1) {
					thisLen++;
				} else if (a1Copy[j] == a1Copy[i]) {
					continue;
				} else {
					break;
				}
			}
			if (thisLen > maxLen) {
				maxLen = thisLen;
				start = thisStart;
			}

		}
		int[] a = new int[maxLen];
		for (int k = 0; k < maxLen; k++) {
			a[k] = start + k;
		}
		return a;
	}

	private static int[] longestContinuousSubsquence2(int[] a1) {
		if (a1 == null || a1.length == 0) {
			return a1;
		}

		Map<Integer, Integer> Index2lengthMap = new HashMap<>();
		int maxLen = 0;
		int maxStart = 0;
		for (int i = 0; i < a1.length; i++) {
			if (!Index2lengthMap.containsKey(a1[i])) {
				Index2lengthMap.put(a1[i], 1);
				int thisLen = 1;
				int thisStart = a1[i];
				int thisEnd = a1[i];
				while (Index2lengthMap.containsKey(thisStart - 1)) {
					thisStart--;
					thisLen++;
				}
				while (Index2lengthMap.containsKey(thisEnd + 1)) {
					thisEnd++;
					thisLen++;
				}
				for (int k = thisStart; k <= thisEnd; k++) {
					Index2lengthMap.put(k,
							Math.max(thisLen, Index2lengthMap.get(k)));
				}
				if (thisLen > maxLen) {
					maxStart = thisStart;
					maxLen = thisLen;
				}

			}
		}
		int[] a = new int[maxLen];
		for (int k = 0; k < maxLen; k++) {
			a[k] = maxStart + k;
		}
		return a;
	}

	private static int[] longestContinuousSubsquence3(int[] a1) {
		if (a1 == null || a1.length == 0) {
			return a1;
		}

		Map<Integer, Integer> Index2lengthMap = new HashMap<>();
		int maxLen = 0;
		int maxStart = 0;
		for (int i = 0; i < a1.length; i++) {
			if (!Index2lengthMap.containsKey(a1[i])) {
				Index2lengthMap.put(a1[i], 1);
				int thisLen = 1;
				int thisStart = a1[i];
				int thisEnd = a1[i];
				while (Index2lengthMap.containsKey(thisStart - 1)) {
					thisStart--;
					thisLen++;
				}
				while (Index2lengthMap.containsKey(thisEnd + 1)) {
					thisEnd++;
					thisLen++;
				}
				for (int k = thisStart; k <= thisEnd; k++) {
					Index2lengthMap.put(k,
							Math.max(thisLen, Index2lengthMap.get(k)));
				}
				if (thisLen > maxLen) {
					maxStart = thisStart;
					maxLen = thisLen;
				}

			}
		}
		int[] a = new int[maxLen];
		for (int k = 0; k < maxLen; k++) {
			a[k] = maxStart + k;
		}
		return a;
	}
}
