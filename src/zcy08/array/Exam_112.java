package zcy08.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_112 {

	public static int getMoreThanHalf(int[] a) {
		if (a == null || a.length == 0) {
			throw new RuntimeException("no");
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
			} else {
				map.put(a[i], 1);
			}
		}
		int len = a.length / 2;
		for (Map.Entry<Integer, Integer> en : map.entrySet()) {
			if (en.getValue() > len) {
				return en.getKey();
			}
		}
		throw new RuntimeException("no");
	}

	public static int getMoreThanHalf2(int[] a) {

		int len = a.length / 2;
		if (a == null || a.length == 0) {
			throw new RuntimeException("no");
		}

		int result = -1;
		for (int i = 0, time = 0; i < a.length; i++) {
			if (time == 0) {
				result = a[i];
				time++;
			} else if (time > 0) {
				if (result == a[i]) {
					time++;
				} else {
					// remove
					time--;
				}
			}
		}

		for (int i = 0, time = 0; i < a.length; i++) {
			if (result == a[i]) {
				time++;
			}
			if (time >= len) {
				return result;
			}
		}
		throw new RuntimeException("no");
	}

	public static void main(String[] args) {
		Random r = new Random();
		int M = 20;
		int[] a1 = new int[M];

		for (int i = 0; i < M / 2; i++) {
			a1[i] = r.nextInt(3);
		}
		CommonUtils.printArray(a1);
		int res = getMoreThanHalf(a1);
		System.out.println(res);
		int res2 = getMoreThanHalf(a1);
		System.out.println(res2);

	}

}
