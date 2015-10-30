package algorithm.graph4.shortest.path;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AcyclicSP {

	private EdgeWeightedDigraph g;
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private int start;

	
	public AcyclicSP(EdgeWeightedDigraph g, int start) {
		super();
		this.g = g;
		this.start = start;
		this.edgeTo = new DirectedEdge[g.vNum()];
		this.distTo = new double[g.vNum()];

		for (int i = 0; i < g.vNum(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}
		distTo[start] = 0;
		Topological top = new Topological(g);
		for (Integer v : top.order()) {
			this.relax(v);
		}

	}

	private void relax(int v) {
		Set<DirectedEdge> edgeSet = this.g.getEdge(v);
		for (DirectedEdge edge : edgeSet) {
			int w = edge.to();

			if (distTo[v] + edge.weight() < distTo[w]) {
				edgeTo[w] = edge;
				distTo[w] = distTo[v] + edge.weight();

			}
		}
	}

	public double distTo(int v) {
		if (!hasPath(v)) {
			return Double.POSITIVE_INFINITY;
		}
		double len = 0d;
		for (DirectedEdge de = edgeTo[v]; de != null; de = edgeTo[de.from()]) {
			len += de.weight();
		}
		return len;
	}

	public boolean hasPath(int v) {
		return v == start || edgeTo[v] != null;
	}

	public List<DirectedEdge> pathTo(int v) {
		if (!hasPath(v)) {
			return null;
		}
		LinkedList<DirectedEdge> list = new LinkedList<>();
		for (DirectedEdge de = edgeTo[v]; de != null; de = edgeTo[de.from()]) {
			list.addFirst(de);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
