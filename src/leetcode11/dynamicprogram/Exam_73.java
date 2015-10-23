package leetcode11.dynamicprogram;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Exam_73 {

	public static int minPath(List<List<Integer>> triangle) {
		int m = triangle.size();
		if (m == 0) {
			return 0;
		}
		List<Integer> path = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			path.add(triangle.get(m - 1).get(i));
		}

		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				int len = triangle.get(i).get(j)
						+ Math.min(triangle.get(i + 1).get(j), triangle.get(i)
								.get(j + 1));
				path.set(j, len);
			}

		}
		return path.get(0);

	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 10;
		List<List<Integer>> triangle = new LinkedList<>();
		System.out.println();
		for (int i = 1; i <= N; i++) {
			List<Integer> list = new LinkedList<>();
			for (int j = 1; j <= i; j++) {
				list.add(r.nextInt(10));
			}
			System.out.println(list);
			triangle.add(list);
		}
		int re = minPath(triangle);
		System.out.println(re);
	}

}
