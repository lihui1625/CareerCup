package leetcode14.stack;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

public class Exam_101 {

	static class Pair implements Comparable<Pair> {
		int index;
		int val;

		public Pair(int index, int val) {
			super();
			this.index = index;
			this.val = val;
		}

		@Override
		public String toString() {
			return "(index=" + index + ", val=" + val + ")";
		}

		@Override
		public int compareTo(Pair o) {

			return this.val != o.val ? (this.val > o.val ? -1 : 1)
					: (this.index > o.index ? -1 : 1);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + val;
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
			Pair other = (Pair) obj;
			if (index != other.index)
				return false;
			if (val != other.val)
				return false;
			return true;
		}
		
		

	}

	public static int[] maxByHeap(int[] in, int w) {
		if (in == null || in.length < w) {
			return null;
		}
		int len = in.length;
		int[] out = new int[len - w + 1];

		PriorityQueue<Pair> heap = new PriorityQueue<>(w);

		for (int i = 0; i < len; i++) {
			heap.add(new Pair(i, in[i]));
			int windowLeft = i - w + 1;
			if (windowLeft >= 0) { 
				Pair peek = heap.peek();
				while (peek.index < windowLeft) {
					heap.poll();
					peek = heap.peek();
				}
				out[windowLeft] = peek.val;
			}
		}
		return out;
 	}
	
	public static int[] maxByTree(int[] in, int w) {
		if (in == null || in.length < w) {
			return null;
		}
		int len = in.length;
		int[] out = new int[len - w + 1];

		TreeSet<Pair> heap = new TreeSet<>();

		for (int i = 0; i < len; i++) {
			heap.add(new Pair(i, in[i]));
			int windowLeft = i - w + 1;
			if (windowLeft >= 0) { 
				Pair peek = heap.first();
				while (peek.index < windowLeft) {
					heap.pollFirst();
					peek = heap.first();
				}
				out[windowLeft] = peek.val;
			}
		}
		return out;
 	}

	public static void main(String[] args) {
		Random r = new Random();
		int N = 20;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {

			a[i] = r.nextInt(10);

		}
		System.out.println(Arrays.toString(a));
		int[] b = maxByHeap(a, 3);
		System.out.println(Arrays.toString(b));
		int[] b2 = maxByHeap(a, 3);
		System.out.println(Arrays.toString(b2));

	}

}
