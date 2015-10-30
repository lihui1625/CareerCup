package zcy08.array;

import java.util.Arrays;
import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_115 {

	public static void main(String[] args) {
		Random r = new Random();
		int M = 20;
		int[] a1 = new int[M];

		for (int i = 0; i < M; i++) {
			a1[i] = r.nextInt(20);
		}
		CommonUtils.printArray(a1);
		print2(a1, 10);
		System.out.println("----------------------");
		print3(a1, 15);

	}

	private static void print2(int[] a1, int k) {
		Arrays.sort(a1);
		int left = 0;
		int right = a1.length - 1;
		while (left < right) {
			if (a1[left] + a1[right] == k) {
				System.out.println(a1[left] + "," + a1[right]);
				left++;
				right--;
			} else if (a1[left] + a1[right] < k) {
				left++;
			} else {
				right--;
			}
		}

	}

	private static void print3(int[] a1, int k) {
		Arrays.sort(a1);

		for (int i = 0; i <= a1.length - 3; i++) {
			int k2 = k - a1[i];
			int left = i + 1;
			int right = a1.length - 1;
			while (left < right) {
				if (a1[left] + a1[right] == k2) {
					System.out
							.println(a1[i] + "," + a1[left] + "," + a1[right]);
					left++;
					right--;
				} else if (a1[left] + a1[right] < k2) {
					left++;
				} else {
					right--;
				}
			}
		}

	}

}
