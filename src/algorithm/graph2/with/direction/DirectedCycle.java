package algorithm.graph2.with.direction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DirectedCycle {

	private boolean[] marked;
	private Map<Integer,Integer> lastV;
	private List<Integer> cycle;
	private boolean[] onStack;
	private DiGraph g;

	public DirectedCycle(DiGraph g) {
		this.g = g;
		this.marked = new boolean[g.vNum()];
		this.onStack = new boolean[g.vNum()];
		this.cycle = new LinkedList<>();
		this.lastV = new HashMap<>();
		for (int i = 0; i < g.vNum(); i++) {
			this.dfs(i);
		}
	}

	private void dfs(int start) {
		this.onStack[start] = true;
		this.marked[start] = true;
		for (Integer v : this.g.adj(start)) {
			if (!this.cycle.isEmpty()) {
				return;
			}
			if (!this.marked[v]) {
				this.lastV.put(v, start);
				this.dfs(v);
			} else if (this.onStack[v]) {
				this.cycle = new LinkedList<>();
				for (int x = start; x != v; x = this.lastV.get(x)) {
					cycle.add(x);
				}
				cycle.add(v);
				cycle.add(start);
			}
		}
		this.onStack[start] = false;
	}
	
	private List<Integer> dfs2(int start) {
		this.onStack[start] = true;
		this.marked[start] = true;
		for (Integer v : this.g.adj(start)) { 
			if (!this.marked[v]) {
				this.lastV.put(v, start);
				this.dfs(v);
			} else if (this.onStack[v]) {
				List<Integer> cycle = new LinkedList<>();
				for (int x = start; x != v; x = this.lastV.get(x)) {
					cycle.add(x);
				}
				cycle.add(v);
				cycle.add(start);
				return cycle;
			}
		}
		this.onStack[start] = false;
		return null;
	}

	

	public boolean hasCycle() {
		return cycle.isEmpty();
	}

	public List<Integer> getCycle() {
		return this.cycle;
	}

	public static void main(String[] args) {
		DiGraph tinyDG = DiGraph.createTinyDG();
		DirectedCycle directedCycle = new DirectedCycle(tinyDG);
		System.out.println(directedCycle.hasCycle() + ":"
				+ directedCycle.getCycle());
		 

	}

}
