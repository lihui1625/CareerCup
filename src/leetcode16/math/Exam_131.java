package leetcode16.math;

import java.util.Arrays;

public class Exam_131 {

	public static int[] nQueue(int qNum) {
		int[] colomns = new int[qNum];
		nQueue(qNum, 0, colomns);
		return colomns;
	}

	private static void nQueue(int qNum, int row, int[] colomns) {
		if (qNum == row) {
			return;
		}
		for (int col = 0; col < qNum; col++) {
			if (!check(row, col, colomns)) {
				continue;
			}
			colomns[row] = col;
			nQueue(qNum, row + 1, colomns);
		}

	}

	private static boolean check(int row, int col, int[] colomns) {

		for (int kRow = 0; kRow < row; kRow++) {
			int kCol = colomns[kRow];
			if (kCol == col || (Math.abs(row - col) == Math.abs(kRow - kCol))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(nQueue(8)));

	}

}
