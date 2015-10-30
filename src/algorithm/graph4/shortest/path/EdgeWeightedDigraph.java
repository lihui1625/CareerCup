package algorithm.graph4.shortest.path;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class EdgeWeightedDigraph {

	private final int vNum;
	private int eNum;
	private Map<Integer, LinkedHashSet<DirectedEdge>> adj;

	public EdgeWeightedDigraph(int vNum) {
		this.vNum = vNum;
		this.eNum = 0;
		this.adj = new LinkedHashMap<>();
	}

	public int vNum() {
		return this.vNum;
	}

	public int eNum() {
		return this.eNum;
	}

	public void addEdge(int v, int w, double weight) {
		if (v < 0 || v > this.vNum) {
			return;
		}
		if (w < 0 || w > this.vNum) {
			return;
		}
		if (!this.adj.containsKey(v)) {
			this.adj.put(v, new LinkedHashSet<DirectedEdge>());
		}
		DirectedEdge d = new DirectedEdge(v, w, weight);
		if (!this.adj.get(v).contains(d)) {
			this.adj.get(v).add(d);
			this.eNum++;
		}
	}

	public  Set<DirectedEdge> getEdge(int v) {
		return this.adj.get(v);
	}

	public LinkedHashSet<DirectedEdge> getAllEdges() {
		LinkedHashSet<DirectedEdge> allEdges = new LinkedHashSet<>();
		for (LinkedHashSet<DirectedEdge> edges : this.adj.values()) {
			allEdges.addAll(edges);
		}

		return allEdges;
	}

	@Override
	public String toString() {
		return "EdgeWeightedDigraph [vNum=" + vNum + ", eNum=" + eNum
				+ ", adj=" + adj + "]";
	}

	public static EdgeWeightedDigraph createTinyEWD() {
		EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(8);
		ewd.addEdge(4, 5, 0.35);
		ewd.addEdge(5, 4, 0.35);
		ewd.addEdge(4, 7, 0.37);
		ewd.addEdge(5, 7, 0.28);
		ewd.addEdge(7, 5, 0.28);
		ewd.addEdge(5, 1, 0.32);
		ewd.addEdge(0, 4, 0.38);
		ewd.addEdge(0, 2, 0.26);
		ewd.addEdge(7, 3, 0.39);
		ewd.addEdge(1, 3, 0.29);
		ewd.addEdge(2, 7, 0.34);
		ewd.addEdge(6, 2, 0.40);
		ewd.addEdge(3, 6, 0.52);
		ewd.addEdge(6, 0, 0.58);
		ewd.addEdge(6, 4, 0.93); 
		return ewd; 
	}
	
	
	public static EdgeWeightedDigraph createTinyEWDnc() {
		EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(8);
		ewd.addEdge(4, 5, 0.35);
		ewd.addEdge(5, 4, -0.66);
		ewd.addEdge(4, 7, 0.37);
		ewd.addEdge(5, 7, 0.28);
		ewd.addEdge(7, 5, 0.28);
		ewd.addEdge(5, 1, 0.32);
		ewd.addEdge(0, 4, 0.38);
		ewd.addEdge(0, 2, 0.26);
		ewd.addEdge(7, 3, 0.39);
		ewd.addEdge(1, 3, 0.29);
		ewd.addEdge(2, 7, 0.34);
		ewd.addEdge(6, 2, 0.40);
		ewd.addEdge(3, 6, 0.52);
		ewd.addEdge(6, 0, 0.58);
		ewd.addEdge(6, 4, 0.93); 
		return ewd; 
	}

	public static void main(String[] args) {
		EdgeWeightedDigraph ewd = EdgeWeightedDigraph.createTinyEWD();
		System.out.println(ewd);
		EdgeWeightedDigraph ewdnc = EdgeWeightedDigraph.createTinyEWDnc();
		System.out.println(ewdnc);

	}

}
