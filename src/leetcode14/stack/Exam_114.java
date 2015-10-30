package leetcode14.stack;

import java.util.PriorityQueue;

public class Exam_114 {

	public static Cell topK(int[][] a, int k) {
		if (a == null || a.length == 0 || a[0].length == 0 || k <= 0) {
			throw new RuntimeException("error");
		}
		int m = a.length;
		int n = a[0].length;
		if (k > m * n) {
			throw new RuntimeException("error");
		}
		PriorityQueue<Cell> heap = new PriorityQueue<>();
		heap.add(new Cell(a[0][0], 0, 0));
 		int count = 0;
		while (!heap.isEmpty()) {
			Cell top = heap.poll();
			count++;
			if (count == k) {
				return top ;
			}
			if (top.x < m - 1) {
 			    heap.add(new Cell(a[top.x + 1][top.y], top.x + 1, top.y)); 
			}
			if (top.y < n - 1) {
 				heap.add(new Cell(a[top.x][top.y + 1], top.x, top.y + 1)); 
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[][] a = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };
		System.out.println(topK(a, 5));

	}

}

class Cell implements Comparable<Cell> {
	int val, x, y;

	public Cell(int val, int x, int y) {
		super();
		this.val = val;
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Cell o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}

	@Override
	public String toString() {
		return "Cell [val=" + val + ", x=" + x + ", y=" + y + "]";
	}

	
}
