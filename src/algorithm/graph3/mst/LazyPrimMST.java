package algorithm.graph3.mst;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

;

public class LazyPrimMST {

	private EdgeWeightedGraph g;
	private boolean[] marked;
	private List<Edge> mst;
	private PriorityQueue<Edge> heap;
	private double totalWeight;

	public LazyPrimMST(EdgeWeightedGraph g) {
		super();
		this.g = g;
		this.marked = new boolean[this.g.vNum()];
		this.mst = new LinkedList<>();
		this.heap = new PriorityQueue<>(this.g.eNum());
		this.visit(0);
	}

	private void visit(int start) {
		if (this.marked[start]) {
			return;
		}
		this.marked[start] = true;
		for (Edge e : g.getEdge(start)) {
			if (!this.marked[e.otherVertex(start)]) {
				this.heap.add(e);
			}

		}
		Edge minEdge = null; 
		while (!this.heap.isEmpty()) {
			Edge e = this.heap.poll();
			int v = e.oneVertex();
			int w = e.otherVertex(v);
			if (!this.marked[v] || !this.marked[w]) {
				minEdge = e;
				break;
			}

		}
		if (minEdge != null) {
			this.mst.add(minEdge);
			totalWeight += minEdge.weight();
			int v = minEdge.oneVertex();
			int w = minEdge.otherVertex(v);
			int notVisit = this.marked[v] ? w : v;
			this.visit(notVisit);
		}
	}

	public List<Edge> mst() {
		return this.mst;
	}

	public double totalWeight() {
		return this.totalWeight;
	}

	@Override
	public String toString() {
		return "LazyPrimMST [mst=" + mst + ", totalWeight=" + totalWeight + "]";
	}

	public static void main(String[] args) {
		EdgeWeightedGraph eg = EdgeWeightedGraph.createTinyGC();
		System.out.println(eg);
		LazyPrimMST lp = new LazyPrimMST(eg);
		System.out.println(lp);

	}

}
