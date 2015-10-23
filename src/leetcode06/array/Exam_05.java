package leetcode06.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exam_05 {

	public static int[] maxIndexDistance(int[] array) {
		if (array == null || array.length < 2) {
			return null;
		}
		int len = array.length;
		boolean[] descIndex = new boolean[len];
		int minValue = array[0];
		descIndex[0] = true;
		for (int i = 1; i < len; i++) {
			if (array[i] < minValue) {
				minValue = array[i];
				descIndex[i] = true;
			}
		}
		int maxDistance = 0;
		int maxLeftPt = 0;
		int maxRightPt = 0;

		int leftPt = len - 1;
		int rightPt = len - 1;

		while (leftPt >= 0) {
			if (descIndex[leftPt]) {
				while (array[rightPt] <= array[leftPt] && rightPt > leftPt) {
					rightPt--;
				}

				if (array[rightPt] > array[leftPt]) {
					int dist = rightPt - leftPt;
					if (dist > maxDistance) {
						maxDistance = dist;
						maxLeftPt = leftPt;
						maxRightPt = rightPt;
					}
				}
			}
			leftPt--;
		}

		return new int[] { maxLeftPt, maxRightPt };
	}

	public static void main(String[] args) {
		int[] a1 = new int[] { 5, 3, 4, 0, 1, 4, 1 };

		int[] r1 = maxIndexDistance(a1);

		System.out.println("a[" + r1[0] + "]=" + a1[r1[0]] + ",a[" + r1[1]
				+ "]=" + a1[r1[1]] + ", len:" + (r1[1] - r1[0]));

		Random r = new Random();
		int N = 20;
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = r.nextInt(10) - 10;
		}
		System.out.println("--------------");
		for (int i = 0; i < N; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println("--------------");

		int[] r2 = maxIndexDistance(array);
		System.out.println("a[" + r2[0] + "]=" + array[r2[0]] + ",a[" + r2[1]
				+ "]=" + array[r2[1]] + ", len:" + (r2[1] - r2[0]));

	}

}
