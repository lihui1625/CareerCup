package algorithm.graph;

public class Walshall {

	public static int[][] caculate(final int[][] linkedMatrix) {
		int M = linkedMatrix.length;
		int[][] connectTable = linkedMatrix.clone();
		for (int mid = 0; mid < M; mid++) {
			for (int left = 0; left < M; left++) {
				if (connectTable[left][mid] > 0) {
					for (int right = 0; right < M; right++) {
						if (connectTable[mid][right] > 0) {
							connectTable[left][right] = 1;
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

				if (connectTable[left][mid] > 0) {
					for (int right = 0; right < M; right++) {
						if (connectTable[mid][right] > 0) {
							connectTable[left][right] = 1;
						}
					}
				}
			}
		}
		return connectTable;
	}

	public static void main(String[] args) {
		int[][] linkedMatrix = new int[][] { { 0, 0, 1, 0, 0 },
				{ 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 0 } };
		int[][] connectTable = Walshall.caculate(linkedMatrix);
		int M = connectTable.length;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(connectTable[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		int[][] connectTable2 = Walshall.caculate2(linkedMatrix);
		int M2 = connectTable2.length;
		for (int i = 0; i < M2; i++) {
			for (int j = 0; j < M2; j++) {
				System.out.print(connectTable2[i][j] + "\t");
			}
			System.out.println();
		}

	}
}
