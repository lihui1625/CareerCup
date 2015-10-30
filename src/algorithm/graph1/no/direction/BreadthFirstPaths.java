package algorithm.graph1.no.direction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BreadthFirstPaths {

	public static List<Integer> pathTo(Graph g, int start, int end) {

		LinkedList<Integer> path = new LinkedList<>();
		if (!g.allEdges().containsKey(start) || !g.allEdges().containsKey(end)) {
			return null;
		}

		if (start == end) {
			path.add(start);
			return path;
		}

		Map<Integer, Integer> lastMap = new HashMap<>();
		lastMap.put(start, null); 
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			Integer v = queue.poll(); 
			Set<Integer> set = g.adj(v);
			boolean isBreak = false;
			for (Integer w : set) {
				if (!lastMap.containsKey(w)) {
					lastMap.put(w, v);
					queue.add(w); 
					if(w.intValue()==end){
						isBreak = true;
						break;
					}
				}
			} 
			if(isBreak){
				break;
			}
		} 

		if (!lastMap.containsKey(end)) {
			return null;
		}
 
		for (Integer v = end; v!=null; v = lastMap.get(v)) {
			path.addFirst(v);
		}
		 
		return path;
	}
	
	public static void main(String[] args) {
		Graph g = Graph.createTinyCG();
		//System.out.println(g);

		for (Integer k : g.allEdges().keySet()) {
			for (Integer x : g.allEdges().keySet()) {
				System.out.println(k + " --> " + x + ":" + pathTo(g, k, x)); 
			}
		}

		Graph g2 = Graph.createTinyCG2();
		//System.out.println(g2);

		for (Integer k : g2.allEdges().keySet()) {
			for (Integer x : g2.allEdges().keySet()) {
				System.out.println(k + " --> " + x + ":" + pathTo(g2, k, x)); 
			}
		}

	}

}
