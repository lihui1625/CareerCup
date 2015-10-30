package zcy09.other;

import java.util.Arrays;
import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_133 {

	private static Random r = new Random();

	private static int random5() {
		return r.nextInt(5) + 1;
	}

	private static int random7() {
		int rand_0_1__4 = random5() - 1;
		int rand_0_5__20 = 5 * (random5() - 1);
		int rand_0_1__24 = 5 * (random5() - 1) + random5() - 1;
		while (rand_0_1__24 > 20) {
			rand_0_1__24 = 5 * (random5() - 1) + random5() - 1;
		}
		return rand_0_1__24 % 7 + 1;
	}

	private static int random7_2() {
		int rand_0_1__4 = random5() - 1;
		int rand_0_5__20 = 5 * (random5() - 1);
		int rand_0_1__24 = 5 * (random5() - 1) + random5() - 1;
		while (rand_0_1__24 > 6) {
			rand_0_1__24 = 5 * (random5() - 1) + random5() - 1;
		}
		return rand_0_1__24 + 1;
	}

	private static int m = 5;

	private static int randomM() {
		return r.nextInt(m) + 1;
	}

	private static int randomN(int n) {
		int newRand = m * (randomM() - 1) + randomM();
		while (newRand > n) {
			newRand = m * (randomM() - 1) + randomM();
		}
		return newRand;
	}

	public static void main(String[] args) {
		int M = 80;
		int[] a1 = new int[M];
		for (int i = 0; i < M; i++) {
			a1[i] = random7();
		}
		Arrays.sort(a1);
		CommonUtils.printArray(a1);
		System.out.println();

		int[] a2 = new int[M];
		for (int i = 0; i < M; i++) {
			a2[i] = random7_2();
		}
		Arrays.sort(a2);
		CommonUtils.printArray(a2);
	}

}
