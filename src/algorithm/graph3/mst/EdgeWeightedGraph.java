package algorithm.graph3.mst;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class EdgeWeightedGraph {

	private final int vNum;
	private int eNum;
	private Map<Integer, Set<Edge>> adj;

	public EdgeWeightedGraph(int vNum) {
		super();
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
		if (v < 0 || v >= this.vNum) {
			return;
		}
		if (w < 0 || w >= this.vNum) {
			return;
		}
		if (this.adj.get(v) == null) {
			this.adj.put(v, new LinkedHashSet<Edge>());
		}
		if (this.adj.get(w) == null) {
			this.adj.put(w, new LinkedHashSet<Edge>());
		}
		Edge edge = new Edge(v, w, weight);
		if (!this.adj.get(v).contains(edge)) {
			this.adj.get(v).add(edge);
			this.adj.get(w).add(edge);
			this.eNum++;
		}

	}

	public Set<Edge> getEdge(int v) {
		return this.adj.get(v);
	}

	public Set<Edge> getAllEdge() {
		Set<Edge> allEdgeSet = new LinkedHashSet<>();
		for (Set<Edge> set : this.adj.values()) {
			allEdgeSet.addAll(set);
		}
		return allEdgeSet;
	}
	
	

	@Override
	public String toString() {
		return "EdgeWeightdGraph [vNum=" + vNum + ", eNum=" + eNum + ", adj="
				+ adj + "]";
	}
	
	public static EdgeWeightedGraph createTinyGC(){
		EdgeWeightedGraph edgeWeightdGraph = new EdgeWeightedGraph(8);
		
		edgeWeightdGraph.addEdge(4, 5, 0.35);
		edgeWeightdGraph.addEdge(4, 7, 0.37);
		edgeWeightdGraph.addEdge(5, 7, 0.28);
		edgeWeightdGraph.addEdge(0, 7, 0.16);
		edgeWeightdGraph.addEdge(1, 5, 0.32);
		edgeWeightdGraph.addEdge(0, 4, 0.38);
		edgeWeightdGraph.addEdge(2, 3, 0.17);
		edgeWeightdGraph.addEdge(1, 7, 0.19);
		edgeWeightdGraph.addEdge(0, 2, 0.26);
		edgeWeightdGraph.addEdge(1, 2, 0.36);
		edgeWeightdGraph.addEdge(1, 3, 0.29);
		edgeWeightdGraph.addEdge(2, 7, 0.34);
		edgeWeightdGraph.addEdge(6, 2, 0.40);
		edgeWeightdGraph.addEdge(3, 6, 0.52);
		edgeWeightdGraph.addEdge(6, 0, 0.58);
		edgeWeightdGraph.addEdge(6, 4, 0.93);
		
		return edgeWeightdGraph;
	}

	public static void main(String[] args) {
		EdgeWeightedGraph eg = EdgeWeightedGraph.createTinyGC();
		System.out.println(eg);

	}

}
