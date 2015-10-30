/**
 * 
 */
package algorithm.graph1.no.direction;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author hui.li
 *
 */
public class CC {

	private Graph g;
	private boolean[] marked;
	private int[] ccId;
	private int count;
	private Map<Integer, Set<Integer>> ccGroup = new HashMap<>();

	public CC(Graph g, boolean bfs) {
		this.g = g;
		this.marked = new boolean[g.vNum()];
		this.ccId = new int[g.vNum()];
		this.count = 0;
		if (bfs) {
			initByBfs();
		} else {
			initByDfs();
		}
		for (int i = 0; i < this.ccId.length; i++) {
			if (!this.ccGroup.containsKey(ccId[i])) {
				ccGroup.put(ccId[i], new LinkedHashSet<Integer>());
			}
			ccGroup.get(ccId[i]).add(i);
		} 
	}

	public void initByBfs() {
		for (int v = 0; v < g.vNum(); v++) {
			if (!this.marked[v]) { 
				this.bfs(v);
				this.count++;
			}
		}
		
	}

	public void initByDfs() {
		for (int v = 0; v < g.vNum(); v++) {
			if (!this.marked[v]) {
				this.dfs(v); 
				this.count++;
			}
		} 
	}

	private void dfs(int s) {
		Set<Integer> set = g.adj(s);
		this.ccId[s] = this.count;
		for (Integer v : set) {
			if (!this.marked[v]) {
				this.marked[v] = true;
				this.dfs(v);
			}
		}
	}

	private void bfs(int s) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		while (!queue.isEmpty()) {
			Integer v = queue.poll();
			Set<Integer> set = g.adj(v);
			for (Integer w : set) {
				if (!this.marked[w]) {
					this.marked[w] = true;
					queue.add(w);
				}
			}
			this.ccId[v] = this.count;
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
		Graph g = Graph.createTinyCG();
		CC cc = new CC(g, true);
		Map<Integer, Set<Integer>> map = cc.getCCGroup();
		for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}

		Graph g2 = Graph.createTinyCG();
		CC cc2 = new CC(g2, false);
		Map<Integer, Set<Integer>> map2 = cc2.getCCGroup();
		for (Map.Entry<Integer, Set<Integer>> e : map2.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}

	}

}
