package bigdata.algorithm06.graph;

public class Dijkstra {

	/**
	 * @param args
	 */
	public static int U = 99999999;

	public static void main(String[] args) {
		int[][] graph = { 
				{ 0, 50, U, 80, U },
				{ U, 0, 60, 90, U },
				{ U, U, 0, U, 40 }, 
				{ U, U, 20, 0, 70 }, 
				{ U, 50, U, U, 0 } };
		int start = 0;
		Path2Len[] path2LenArray = getShorestPath(graph, start);
		for (int i = 0; i < path2LenArray.length; i++) {
			Path2Len path2Len = path2LenArray[i];
			int lastVetrex = path2Len.lastVetrex;
			System.out.print("from " + start + " to " + i + " length:"
					+ path2Len.len + ", path: " + i + " <-- " + lastVetrex);

			while (lastVetrex != start) {
				lastVetrex = path2LenArray[lastVetrex].lastVetrex;
				System.out.print(" <--" + lastVetrex);

			}
			System.out.println();
		}

	}

	public static Path2Len[] getShorestPath(int[][] graph, int start) {
		int N = graph.length;
		Path2Len[] path2LenArray = new Path2Len[N];
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			Path2Len path2Len = new Path2Len();
			path2Len.lastVetrex = start;
			path2Len.len = graph[start][i];
			path2LenArray[i] = path2Len;
			visited[i] = false;
			System.out.println("init " + start + " --> " + i + ":    "
					+ path2Len.len);
		}

		visited[start] = true;

		for (int count = 0; count < N - 1; count++) {
			int minIndex = -1;
			int minLen = U;
			for (int i = 0; i < N; i++) {
				if (!visited[i] && path2LenArray[i].len < minLen) {
					minLen = path2LenArray[i].len;
					minIndex = i;
				}
			}
			if (minLen == U) {
				break;
			}
			visited[minIndex] = true;

			for (int i = 0; i < N; i++) {
				if (!visited[i]
						&& graph[minIndex][i] < U
						&& path2LenArray[minIndex].len + graph[minIndex][i] < path2LenArray[i].len) {
					path2LenArray[i].len = path2LenArray[minIndex].len
							+ graph[minIndex][i];
					path2LenArray[i].lastVetrex = minIndex;
					System.out.println("update " + start + " --> " + i
							+ " via " + minIndex + ":   "
							+ path2LenArray[i].len);
				}
			}
		}

		return path2LenArray;
	}

	
}

class Path2Len {
	public int lastVetrex;
	public int len;
	@Override
	public String toString() {
		return "Path2Len [lastVetrex=" + lastVetrex + ", len=" + len + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lastVetrex;
		result = prime * result + len;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Path2Len other = (Path2Len) obj;
		if (lastVetrex != other.lastVetrex)
			return false;
		if (len != other.len)
			return false;
		return true;
	}
	
	
}