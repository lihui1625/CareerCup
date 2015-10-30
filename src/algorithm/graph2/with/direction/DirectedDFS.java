package algorithm.graph2.with.direction;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DirectedDFS {

	private boolean[] marked;
	private DiGraph diGraph;

	public DirectedDFS(DiGraph diGraph) {
		this.diGraph = diGraph;
		this.marked = new boolean[diGraph.vNum()];
	}

	public void dfs(int start) {
		this.marked[start] = true;
		Set<Integer> adjSet = this.diGraph.adj(start);
		for (Integer v : adjSet) {
			if (!this.marked[v]) {
				this.dfs(v);
			}
		}
	}

	public List<Integer> dfs2(int start) {
		List<Integer> result = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		while (!stack.isEmpty()) {
			Integer v = stack.peek();
			if (!result.contains(v)) {
				result.add(v);
			}
			Set<Integer> adjSet = this.diGraph.adj(start);
			boolean toRemove = true;
			for (Integer w : adjSet) {
				if (!result.contains(w)) {
					stack.push(w);
					toRemove = false;
				}
			}
			if (toRemove) {
				stack.pop();
			}
		}

		return result;
	}

	public List<Integer> bfs(int start) {
		List<Integer> result = new LinkedList<>();

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			Integer v = queue.poll();
			if (!result.contains(v)) {
				result.add(v);
			}
			Set<Integer> adjSet = this.diGraph.adj(start);
			for (Integer w : adjSet) {
				if (!result.contains(w)) {
					queue.add(w);
				}
			}
		}
		return result;
	}

	public boolean isMarked(int v) {
		return this.marked[v];
	}

	public void reset() {
		for (int i = 0; i < this.marked.length; i++) {
			this.marked[i] = false;
		}

	}

	public static void main(String[] args) {
		DiGraph tinyDG = DiGraph.createTinyDG();
		DirectedDFS directedDFS = new DirectedDFS(tinyDG);
		for (int i = 0; i < directedDFS.diGraph.vNum(); i++) {
			System.out.println(i + ":" + directedDFS.dfs2(i));
			System.out.println(i + ":" + directedDFS.bfs(i));
		}
	}

}
