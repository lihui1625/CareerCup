package career01.array;

import java.util.HashSet;
import java.util.Set;

public class Exam_1_7 {

	public static void clear(int[][] m) {
		if (m == null) {
			return;
		}

		int x = m.length;
		if (x == 0) {
			return;
		}
		int y = m[0].length;
		if (y == 0) {
			return;
		}

		Set<Integer> setx = new HashSet<>(x);
		Set<Integer> sety = new HashSet<>(y);
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (m[x][y] == 0) {
					setx.add(i);
					sety.add(j);
				}
			}

		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; i < y; i++) {
				if (setx.contains(i) || setx.contains(j)) {
					m[i][j] = 0;
				}

			}

		}

	}

	public static void clear2(int[][] m) {
		if (m == null) {
			return;
		}

		int x = m.length;
		if (x == 0) {
			return;
		}
		int y = m[0].length;
		if (y == 0) {
			return;
		}

		boolean[] setx = new boolean[x];
		boolean[] sety = new boolean[y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (m[x][y] == 0) {
					setx[i] = true;
					sety[j] = true;
				}
			}

		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; i < y; i++) {
				if (setx[i] || sety[j]) {
					m[i][j] = 0;
				}

			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
