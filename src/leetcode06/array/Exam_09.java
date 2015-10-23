package leetcode06.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Exam_09 {

	public static boolean divide(int[] array, int k) {

		if (k % 2 != 0) {
			return false;
		}
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			int key = array[i] % k;
			if (map.containsKey(key)) {
				map.get(key).add(array[i]);
			} else {
				List<Integer> list = new LinkedList<>();
				list.add(array[i]);
				map.put(key, list);
			}
		}

		int totalCount = 0;

		for (int i = 0; i < k / 2; i++) {
			int cnt1 = map.get(i) == null ? 0 : map.get(i).size();
			int cnt2 = map.get(k - i) == null ? 0 : map.get(i).size();
			int realCnt = Math.min(cnt1, cnt2);
			totalCount += realCnt;
		}
		totalCount += (map.get(k / 2) == null ? 0 : map.get(k / 2).size()) / 2;

		return totalCount >= array.length / 2;

	}

	public static void main(String[] args) {
		int N = 20;
		int[] array = new int[N];

		Random r = new Random();
		for (int i = 0; i < N; i++) {
			array[i] = r.nextInt(20);
		}

	}

}
