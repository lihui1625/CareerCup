package zcy08.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_110 {

	public static int[] topK(int[] array, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(k,
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.intValue() > o2.intValue() ? -1 : 1;
					}

				});
		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				heap.add(array[i]);
			} else {
				int top = heap.peek();
				if (top < array[i]) {
					continue;
				} else {
					heap.add(array[i]);
					heap.poll();
				}
			}
		}
		int[] res = new int[heap.size()];
		int i = 0;
		while (!heap.isEmpty()) {
			res[i++] = heap.poll();
		}
		return res;

	}

	public static void main(String[] args) {
		Random r = new Random();
		int M = 20;
		int[] a1 = new int[M];

		for (int i = 0; i < M; i++) {
			a1[i] = r.nextInt(50);
		}
		CommonUtils.printArray(a1);
		int[] res = topK(a1, 5);
		CommonUtils.printArray(res);

	}

}
