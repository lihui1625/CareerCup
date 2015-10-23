package leetcode06.array;

import java.util.Random;

public class Exam_04 {

	public static void spin(int[] array, int k) {
		if (array == null || array.length < 2) {
			return;
		}
		int len = array.length;
		if (k < 0 || k >= len) {
			return;
		}
		for (int i = 0; i < k; i++) {
			int t = array[0];
			for (int j = 1; j < len; j++) {
				array[j - 1] = array[j];
			}
			array[len - 1] = t;
		}

	}

	public static void spin2(int[] array, int k) {
		if (array == null || array.length < 2) {
			return;
		}
		int len = array.length;
		k = k % len;
		if (k <= 0) {
			return;
		}

		reverse(array, 0, array.length - 1);

		System.out.println("------reverse 1-------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println("");

		reverse(array, 0, k - 1);

		System.out.println("------reverse 2-------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println("");

		reverse(array, k, array.length - 1);

		System.out.println("------reverse 3-------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println();
	}

	private static void reverse(int[] array, int left, int right) {
		// for (int start = left; start <= right; start++) {
		// int end = right + left - start;
		// if (start >= end) {
		// break;
		// }
		// int tmp = array[start];
		// array[start] = array[end];
		// array[end] = tmp;
		// }

		while (left < right) {

			int tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 20;
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = r.nextInt(50) - 25;
		}
		System.out.println("----init------");
		for (int i = 0; i < N; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println("--------------");

		spin2(array, 5);

	}

}
