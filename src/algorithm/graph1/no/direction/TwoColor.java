package algorithm.graph1.no.direction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TwoColor {

	private Graph g;
	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColorable = true;

	public TwoColor(Graph g) {
		super();
		this.g = g;
		this.marked = new boolean[g.vNum()];
		this.color = new boolean[g.vNum()];
		for (int s = 0; s < g.vNum() && this.isTwoColorable; s++) {
			if (!this.marked[s]) {
				if (this.isTwoColorable) {
					return;
				}
				// this.dfs(s);
				this.bfs(s);
			}
		}
	}

	private void dfs(int v) {
		this.marked[v] = true;
		Set<Integer> set = g.adj(v);
		for (Integer w : set) {
			if (!this.marked[w]) {
				this.color[w] = !this.color[v];
				this.dfs(w);
			} else if (this.marked[w] && this.color[w] == this.color[v]) {
				this.isTwoColorable = false;
				break;
			}
		}
	}

	private void bfs(int s) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Integer v = queue.poll();
			this.marked[v] = true;
			Set<Integer> set = g.adj(v);
			for (Integer w : set) {
				if (!this.marked[w]) {
					this.marked[w] = true;
					this.color[w] = !this.color[v];
					queue.add(w);
				} else if (this.marked[w] && this.color[w] == this.color[v]) {
					this.isTwoColorable = false;
					return;
				}
			}
		}
	}

	public boolean isTwoColorable() {
		return isTwoColorable;
	}

	public static void main(String[] args) {
		Graph g2 = Graph.createTinyCG2();
		TwoColor twoColor2 = new TwoColor(g2);
		System.out.println(twoColor2.isTwoColorable());

		Graph g = Graph.createTinyCG();
		TwoColor twoColor = new TwoColor(g);
		System.out.println(twoColor.isTwoColorable());

	}

}
