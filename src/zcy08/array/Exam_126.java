package zcy08.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_126 {

	public static int[] topK(int[][] a, int k) {
		class Node {
			int[] p;
			int index;

			public Node(int[] p) {
				super();
				this.p = p;
			}

		}

		PriorityQueue<Node> p = new PriorityQueue<>(a.length,
				new Comparator<Node>() {

					@Override
					public int compare(Node o1, Node o2) {
						// TODO Auto-generated method stub
						return o1.p[o1.index]- o2.p[o2.index] ;
					}

				});

		for (int i = 0; i < a.length; i++) {
			if (a[i] == null || a[i].length == 0) {
				continue;
			}
			Node node = new Node(a[i]);
			p.add(node);
		}

		int[] res = new int[k];
		for (int j = 0; j < k && !p.isEmpty(); j++) {
			Node node = p.poll();
			res[j] = node.p[node.index];
			node.index++;
			if (node.index < node.p.length) {
				p.add(node);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Random r = new Random();
		int[][] aa = new int[8][];
		for (int i = 0; i < 8; i++) {
			int M = r.nextInt(8) + 1;
			int[] a1 = new int[M];

			for (int j = 0; j < M; j++) {
				a1[j] = r.nextInt(50);
			}
			Arrays.sort(a1);
			CommonUtils.printArray(a1);
			aa[i] = a1;
		}
		int[] b = topK(aa, 8);
		CommonUtils.printArray(b);

	}

}
