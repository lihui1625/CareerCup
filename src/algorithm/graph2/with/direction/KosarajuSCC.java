package algorithm.graph2.with.direction;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class KosarajuSCC {

	private DiGraph g;
	private boolean[] marked;
	private int[] ccId;
	private int count;
	private Map<Integer, Set<Integer>> ccGroup = new HashMap<>();

	public KosarajuSCC(DiGraph g) {
		this.g = g;
		this.marked = new boolean[g.vNum()];
		this.ccId = new int[g.vNum()];
		this.count = 0;
		DepthFirstOrder order = new DepthFirstOrder(g);
		Stack<Integer> set = order.getReversePost();
		System.out.println(set);
		while (!set.isEmpty()) {
			Integer v = set.pop();
			if (!this.marked[v]) {
				this.dfs(v);
				this.count++;
			}
		}
		for (int i = 0; i < this.ccId.length; i++) {
			if (!this.ccGroup.containsKey(ccId[i])) {
				ccGroup.put(ccId[i], new LinkedHashSet<Integer>());
			}
			ccGroup.get(ccId[i]).add(i);
		}

	}

	private void dfs(int start) {
		this.marked[start] = true;
		this.ccId[start] = this.count;
		Set<Integer> set = g.adj(start);
		for (Integer v : set) {
			if (!this.marked[v]) {
				this.dfs(v);
			}
		}
	}

	private void bfs(int s) {
		this.marked[s] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Integer v = queue.poll();
			this.ccId[v] = this.count;
			Set<Integer> set = g.adj(v);
			for (Integer w : set) {
				if (!this.marked[w]) {
					queue.add(w);
				}
			}
		}
	}

	public boolean isConnected(int v, int w) {
		if (v < 0 || w < 0 || v >= this.ccId.length || w >= this.ccId.length) {
			return false;
		}
		return this.ccId[v] == this.ccId[w];
	}

	public int ccCount() {
		return this.count;
	}

	public int ccId(int v) {
		if (v < 0 || v >= this.ccId.length) {
			return -1;
		}
		return this.ccId[v];
	}

	public Map<Integer, Set<Integer>> getCCGroup() {
		return ccGroup;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DiGraph g = DiGraph.createTinyDG();
		KosarajuSCC cc = new KosarajuSCC(g);
		Map<Integer, Set<Integer>> map = cc.getCCGroup();
		for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
	}

}
