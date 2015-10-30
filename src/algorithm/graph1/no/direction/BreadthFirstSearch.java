package algorithm.graph1.no.direction;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
 

	public static Set<Integer> bfs(Graph g, int start) {

		Set<Integer> list = new LinkedHashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			Integer v = queue.poll();
			if (!list.contains(v)) {
				list.add(v);
			}
			Set<Integer> set = g.adj(v);
			for (Integer w : set) {
				if (!list.contains(w)) {
					queue.add(w); 
				}
			} 
		}
		return list;

	}

	public static void main(String[] args) {
		Graph g = Graph.createTinyCG();
		//System.out.println(g);

		for (Integer k : g.allEdges().keySet()) {
			System.out.println("");
			System.out.println(k + " --> " + BreadthFirstSearch.bfs(g, k)); 
		}

		
		Graph g2 = Graph.createTinyCG2();
		//System.out.println(g2);

		for (Integer k : g2.allEdges().keySet()) {
			System.out.println("");
			System.out.println(k + " --> " + BreadthFirstSearch.bfs(g2, k)); 
		}
	}

}
