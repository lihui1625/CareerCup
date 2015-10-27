package zcy04.recursion.dynamic;

import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_069 {

	public static void main(String[] args) {
//		Random r = new Random();
//		int M = 20;
//		int[] a1 = new int[M];
//
//		for (int i = 0; i < M; i++) {
//			a1[i] = r.nextInt(10);
//		}
		int[] a1 =new int[] {3,2,3,1,1,4};
		CommonUtils.printArray(a1);
		int path = jump(a1);
		System.out.println(path);

	}

	private static int jump(int[] a1) {
		if (a1 == null || a1.length == 0) {
			return 0;
		}
		int jump = 0;
		int cur = 0;
		int next = 0;
		for (int i = 0; i < a1.length; i++) {
			if (cur < i) {
				jump++;
				cur = next;
			}
			next = Math.max(next, i + a1[i]);
		}

		return jump;
	}

}
