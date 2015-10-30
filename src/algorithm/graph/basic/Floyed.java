package algorithm.graph.basic;

public class Floyed {

	public final static int UNLIMITED = Integer.MAX_VALUE;

	public static int[][] caculate(final int[][] linkedMatrix) {
		int M = linkedMatrix.length;
		int[][] connectTable = linkedMatrix.clone();
		for (int mid = 0; mid < M; mid++) {
			for (int left = 0; left < M; left++) {
				if (connectTable[left][mid] < UNLIMITED) {
					for (int right = 0; right < M; right++) {
						if (connectTable[mid][right] < UNLIMITED) {
							int newValue = connectTable[left][mid]
									+ connectTable[mid][right];
							if (newValue < connectTable[left][right]) {
								connectTable[left][right] = newValue;
							}
						}
					}
				}
			}
		}
		return connectTable;
	}

	public static int[][] caculate2(final int[][] linkedMatrix) {
		int M = linkedMatrix.length;
		int[][] connectTable = linkedMatrix.clone();
		for (int left = 0; left < M; left++) {
			for (int mid = 0; mid < M; mid++) {
				if (connectTable[left][mid] < UNLIMITED) {
					for (int right = 0; right < M; right++) {
						if (connectTable[mid][right] < UNLIMITED) {
							int newValue = connectTable[left][mid]
									+ connectTable[mid][right];
							if (newValue < connectTable[left][right]) {
								connectTable[left][right] = newValue;
							}
						}
					}
				}
			}
		}
		return connectTable;
	}

	public static void main(String[] args) {
		int[][] linkedMatrix = new int[][] {
				{ 0, 50, UNLIMITED, 80, UNLIMITED },
				{ UNLIMITED, 0, 60, 90, UNLIMITED },
				{ UNLIMITED, UNLIMITED, 0, UNLIMITED, 40 },
				{ UNLIMITED, UNLIMITED, 20, 0, 70 },
				{ UNLIMITED, 50, UNLIMITED, UNLIMITED, 0 } };
		int[][] connectTable = Floyed.caculate(linkedMatrix);
		int M = connectTable.length;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print((connectTable[i][j] == UNLIMITED ? "-"
						: connectTable[i][j]) + "\t");
			}
			System.out.println();
		}
		System.out.println();
		int[][] connectTable2 = Floyed.caculate2(linkedMatrix);
		int M2 = connectTable2.length;
		for (int i = 0; i < M2; i++) {
			for (int j = 0; j < M2; j++) {
				System.out.print((connectTable2[i][j] == UNLIMITED ? "-"
						: connectTable[i][j]) + "\t");
			}
			System.out.println();
		}

	}
}
