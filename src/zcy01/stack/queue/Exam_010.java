package zcy01.stack.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_010 {

	static public int getNum(int[] a1, int num) {
		if (a1 == null || a1.length == 0) {
			return 0;
		}
		Deque<Integer> dequeMin = new LinkedList<>();
		Deque<Integer> dequeMax = new LinkedList<>();
		int count = 0;
		int i = 0, j = 0;
		while (i < a1.length) {
			while (j < a1.length) {
				while (!dequeMin.isEmpty() && a1[dequeMin.peekLast()] >= a1[j]) {
					dequeMin.pollLast();
				}
				dequeMin.addLast(j);
				while (!dequeMax.isEmpty() && a1[dequeMax.peekLast()] <= a1[j]) {
					dequeMax.pollLast();
				}
				dequeMax.addLast(j);
				if (a1[dequeMax.getFirst()] - a1[dequeMin.getFirst()] > num) {
					break;
				}
				j++;
			}
			if (dequeMin.peekFirst() == i) {
				dequeMin.pollFirst();
			}
			if (dequeMax.peekFirst() == i) {
				dequeMax.pollFirst();
			}
			System.out.println(j+" - "+i+" = "+(j-i));
			count += j - i;
			i++;
		}
		return count;
	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 10;
		int[] a1 = new int[N];

		for (int j = 0; j < N; j++) {
			a1[j] = r.nextInt(10);
		}

		CommonUtils.printArray(a1);
		System.out.println(getNum(a1, -1));
		System.out.println(getNum(a1, 0));
		System.out.println(getNum(a1, 1));
		System.out.println(getNum(a1, 2));

	}

}
