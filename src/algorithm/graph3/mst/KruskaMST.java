package algorithm.graph3.mst;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class KruskaMST {

	private EdgeWeightedGraph g;
	private List<Edge> mst;
	private double totalWeight;

	public KruskaMST(EdgeWeightedGraph g) {
		this.g = g;
		this.mst = new LinkedList<>();
		this.construct();
	}

	private void construct() {
		PriorityQueue<Edge> heap = new PriorityQueue<>();
		Set<Edge> allEdges = this.g.getAllEdge();
		heap.addAll(allEdges);
		List<HashSet<Integer>> allGroups = new LinkedList<HashSet<Integer>>();
		while (!heap.isEmpty() && mst.size() < g.vNum() - 1) {
			Edge edge = heap.poll();
			int v = edge.oneVertex();
			int w = edge.otherVertex(v);
			HashSet<Integer> vGroup = null;
			HashSet<Integer> wGroup = null;
			for (HashSet<Integer> group : allGroups) {
				if (group.contains(v)) {
					vGroup = group;
				}
				if (group.contains(w)) {
					wGroup = group;
				}
			}
			if (vGroup != null && wGroup != null && vGroup == wGroup) {
				continue;
			} else if (vGroup == null && wGroup == null) {
				HashSet<Integer> unionGroup = new HashSet<>();
				unionGroup.add(v);
				unionGroup.add(w);
				allGroups.add(unionGroup);
			} else if (vGroup != null && wGroup != null) {
				wGroup.addAll(vGroup);
				vGroup.clear();
				allGroups.remove(vGroup);
			} else if (vGroup != null) {
				vGroup.add(w);
			} else if (wGroup != null) {
				wGroup.add(v);
			}
			this.mst.add(edge);
			totalWeight += edge.weight();

		}
	}

	private void construct2() {
		PriorityQueue<Edge> heap = new PriorityQueue<>();
		Set<Edge> allEdges = this.g.getAllEdge();
		heap.addAll(allEdges);
		UF uf = new UF(g.vNum());
		while (!heap.isEmpty() && mst.size() < g.vNum() - 1) {
			Edge edge = heap.poll();
			int v = edge.oneVertex();
			int w = edge.otherVertex(v);
			if (!uf.connected(v, w)) {
				uf.union(v, w);
				this.mst.add(edge);
				totalWeight += edge.weight();
			}
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
		return "KruskaMST [mst=" + mst + ", totalWeight=" + totalWeight + "]";
	}

	public static void main(String[] args) {
		EdgeWeightedGraph eg = EdgeWeightedGraph.createTinyGC();
		System.out.println(eg);
		KruskaMST lp = new KruskaMST(eg);
		System.out.println(lp);

	}

}
