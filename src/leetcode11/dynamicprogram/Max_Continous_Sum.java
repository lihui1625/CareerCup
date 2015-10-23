package leetcode11.dynamicprogram;

import java.util.Random;

public class Max_Continous_Sum {

	public static int[] maxContinousSum(int[] array) {

		if (array == null || array.length == 0) {
			return null;
		}

		int start = 0;
		int end = 0;

		int max = array[0];
		int sum = array[0];

		int currentStart = start;
		for (int i = 1; i < array.length; i++) {
			if (sum <= 0) {
				sum = array[i];
				currentStart = i;
			} else {
				sum += array[i];
			}

			if (sum > max) {
				
				max = sum;
				start = currentStart;
				end = i;
				System.out.println("change start:" + start + ", end:" + end + ",  max:" + max);
			}
		}
		return new int[] { start, end, max };
	}

	public static int maxContinousSum_Rec(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		return maxContinousSum_Rec(array, 0, array.length - 1);
	}

	private static int maxContinousSum_Rec(int[] array, int from, int to) {
		if (from == to) {
			return Math.max(array[from], 0);
		}
		int mid = (from + to) / 2;
		int maxLeftSum = maxContinousSum_Rec(array, from, mid);
		int maxRightSum = maxContinousSum_Rec(array, mid + 1, to);

		int maxLeftBorderSum = 0;
		int leftBorderSum = 0;

		for (int i = mid; i >= from; i--) {
			leftBorderSum += array[i];
			maxLeftBorderSum = Math.max(maxLeftBorderSum, leftBorderSum);
		}

		int maxRightBorderSum = 0;
		int rightBorderSum = 0;

		for (int i = mid + 1; i <= to; i++) {
			rightBorderSum += array[i];
			maxRightBorderSum = Math.max(maxRightBorderSum, rightBorderSum);
		}

		return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum
				+ maxRightBorderSum);
	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 50;
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = r.nextInt(100) - 60;
		}
		int[] result = maxContinousSum(array);
		System.out.println();
		System.out.println("start:" + result[0] + "  end:" + result[1]);
		for (int i = result[0]; i <= result[1]; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println();
		System.out.println("sum:" + result[2]);
	}

}
