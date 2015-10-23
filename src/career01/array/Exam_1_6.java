package career01.array;

import java.security.InvalidParameterException;

public class Exam_1_6 {

	public static void   transform(int[][] m) {

		if(m==null || m.length == 0)
		{
			return;
		}
		int N = m.length;
		if(m[0].length != N)
		{
			throw new InvalidParameterException(" The array must be square ");
		}
		
		for (int i = 0; i < N/2; i++) { //可以举个例子，如N=4，看要不要等号。
			for (int j = i; j < N-1-i; j++) { //不要等号，否则尖角的元素会移动两次
				int t = m[i][j];
				m[i][j] = m[N-1-j][i];
				m[N-1-j][i] = m[N-1-i][N-1-j];
				m[N-1-i][N-1-j] = m[j][N-1-i];				
				m[j][N-1-i]=t;
			}

		} 
	}

	public static void printArray(int[][] m) {
		if(m==null || m.length == 0)
		{
			return;
		}
		int N = m.length;
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int t = m[i][j];
				System.out.print(t + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] m = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printArray(m);
		transform(m);
		printArray(m);
		
		m = new int[][] { { 1, 2}, {3, 4 }};
		printArray(m);
		transform(m);
		printArray(m);
	}

}
