package career04.tree.graph;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

	public int VetrixNum;
	public int[][] edges;

	public static int LENGTH_NO_CONNECT = 99999;

	public Graph(int VetrixNum) {
		if (VetrixNum < 0) {
			throw new InvalidParameterException("");
		}
		this.VetrixNum = VetrixNum;
		this.edges = new int[VetrixNum][VetrixNum];
		for (int i = 0; i < VetrixNum; i++) {
			for (int j = 0; j < VetrixNum; j++) {
				this.edges[i][j] = LENGTH_NO_CONNECT;
			}
		}
	}

	public void addEdge(int from, int to, int length) {
		if (from < 0 || from > this.VetrixNum) {
			throw new InvalidParameterException("");
		}
		if (to < 0 || to > this.VetrixNum) {
			throw new InvalidParameterException("");
		}
		if (length < 0) {
			throw new InvalidParameterException("");
		}
		this.edges[from][to] = length;
	}

	public void removEdge(int from, int to) {
		if (from < 0 || from > this.VetrixNum) {
			throw new InvalidParameterException("");
		}
		if (to < 0 || to > this.VetrixNum) {
			throw new InvalidParameterException("");
		}
		this.edges[from][to] = LENGTH_NO_CONNECT;
	}

	public List<Integer> getRelatedVetrex(int start) {
		int[] array = this.edges[start];
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			if (i != start && array[i] < LENGTH_NO_CONNECT) {
				list.add(i);
			}
		}
		return list;
	}

	public void bfs(int start) {
		Set<Integer> visitedSet = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			Integer i = queue.poll();
			if (!visitedSet.contains(i)) {
				System.out.println(i);
				visitedSet.add(i);
				List<Integer> relatedVetrex = this.getRelatedVetrex(i);
				for (Integer re : relatedVetrex) {
					queue.add(re);
				}
			}
		}
		visitedSet.clear(); 
	}

	public void dfs(int start) {
		Set<Integer> visitedSet = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		stack.add(start);

		while (!stack.isEmpty()) {
			Integer i = stack.pop();
			if (!visitedSet.contains(i)) {
				System.out.println(i);
				visitedSet.add(i);
				List<Integer> relatedVetrex = this.getRelatedVetrex(i);
				for (Integer re : relatedVetrex) {
					stack.add(re);
				}
			}
		}
		visitedSet.clear(); 

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
