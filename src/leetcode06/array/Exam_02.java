package leetcode06.array;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Exam_02 {

	public static void sumTwo(int[] array, int sum) {
		if (array == null || array.length < 2) {
			throw new InvalidParameterException(
					" array size must be greater than 1 ");
		}
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.get(array[i]).add(i);
			} else {
				List<Integer> list = new LinkedList<>();
				list.add(i);
				map.put(array[i], list);
			}
		}
		for (int i = 0; i < array.length; i++) {
			int required = sum - array[i];
			if (map.containsKey(required)) {
				List<Integer> list = map.get(required);
				for (Integer index : list) {
					if (index != i)
						System.out.println("a[" + i + "] + a[" + index
								+ "] = (" + array[i] + ") + (" + required
								+ ") = " + sum);
				}
			}

		}
	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 100;
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = r.nextInt(50) - 25;
		}
		sumTwo(array, 10);

	}

}
