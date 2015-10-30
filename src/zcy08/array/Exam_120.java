package zcy08.array;

import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_120 {

	public static void main(String[] args) {
		Random r = new Random();
		int M = 20;
		int[] a1 = new int[M];

		for (int i = 0; i < M; i++) {
			a1[i] = r.nextInt(10) - 5;
		}
		CommonUtils.printArray(a1);

		sort(a1);
		CommonUtils.printArray(a1);

	}

	private static void sort(int[] a1) {
		// TODO Auto-generated method stub
		
	}

}
