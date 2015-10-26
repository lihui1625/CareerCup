/**
 * 
 */
package zcy04.recursion.dynamic;

import java.security.InvalidParameterException;

/**
 * @author hui.li
 *
 */
public class Exam_055 {

	static public long f1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2)
			return 1;
		return f1(n - 1) + f1(n - 2);
	}

	static public long f2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2)
			return 1;
		int result_last_2 = 0;
		int result_last_1 = 1;
		int result = 1;
		for (int i = 3; i <= n; i++) {
			result_last_2 = result_last_1;
			result_last_1 = result;
			result = result_last_1 + result_last_2;
		}
		return result;
	}

	static public long f3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2)
			return 1;
		int[][] m = new int[][] { { 1, 1 }, { 1, 0 } };
		int[][] result = matrixPower(m, n - 2);
		return result[0][0] + result[1][0];
	}

	static private int[][] matrixPower(int[][] m, int n) {
		if(n<0){
			throw new InvalidParameterException(" N should be greater than 0! ");
		}
		int[][] result = new int[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			result[i][i] = 1;
		}
		int[][] m_k = null;
		for (int s = n, i = 1; s > 0; s = s >> 1, i++) {
			if (i == 1) {
				m_k = m;
			} else {
				m_k = matrixMultiply(m_k, m_k);
			}

			if (((s & 1) != 0)) {
				result = matrixMultiply(result, m_k);
			}

		}

		return result;
	}

	static private int[][] matrixMultiply(int[][] x, int[][] y) {
		int[][] result = new int[x.length][y[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < y[0].length; j++) {
				for (int k = 0; k < y.length; k++) {
					result[i][j] += x[i][k] * y[k][j];
				}
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long t1 = System.currentTimeMillis();

		System.out.println();
		for (int i = 1; i < 20; i++) {
			// System.out.print(f1(i) + "\t");
		}
		System.out.println();

		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

		System.out.println();
		for (int i = 1; i < 5000000; i++) {
			// System.out.print(f2(i) + "\t");
			f2(i);
		}
		System.out.println();

		long t3 = System.currentTimeMillis();
		System.out.println(t3 - t2);

		System.out.println();
		for (int i = 1; i < 5000000; i++) {
			// System.out.print(f3(i) + "\t");
			f3(i);
		}
		System.out.println();

		long t4 = System.currentTimeMillis();
		System.out.println(t4 - t3);
	}

}
