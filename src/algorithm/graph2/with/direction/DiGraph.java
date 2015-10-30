package algorithm.graph2.with.direction;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class DiGraph {

	private final int vNum;
	private int eNum;
	private HashSet<Integer>[] adj;

	public DiGraph(int vNum) {
		this.vNum = vNum;
		this.eNum = 0;
		this.adj = new HashSet[vNum];
		for (int i = 0; i < vNum; i++) {
			this.adj[i] = new HashSet<Integer>();
		}
	}

	public int vNum() {
		return this.vNum;
	}

	public int eNum() {
		return this.eNum;
	}

	public void addEdge(int v, int w) {
		if (v >= this.vNum || v < 0) {
			return;
		}
		if (w >= this.vNum || w < 0) {
			return;
		}

		this.adj[v].add(w);
		this.eNum++;
	}

	@SuppressWarnings("unchecked")
	public Set<Integer> adj(int v) {
		HashSet<Integer> set = this.adj[v];
		return (set == null ? Collections.EMPTY_SET : set);
	}

	public Set<Integer> inAdj(int v) {
		HashSet<Integer> resultSet = new HashSet<Integer>();
		for (int w = 0; w < this.vNum; w++) {
			if (this.adj[w].contains(v)) {
				resultSet.add(w);
			}
		}
		return resultSet;
	}

	public DiGraph reverse() {
		DiGraph reverseDiGraph = new DiGraph(this.vNum);
		for (int v = 0; v < this.vNum; v++) {
			HashSet<Integer> entry = this.adj[v];
			for (Integer w : entry) {
				reverseDiGraph.addEdge(w, v);
			}
		}
		return reverseDiGraph;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DiGraph [vNum=" + vNum + ", eNum=" + eNum + "]:\n");
		for (int v = 0; v < this.vNum; v++) {
			HashSet<Integer> entry = this.adj[v];
			sb.append(v + " --> " + entry + "\n");
		}
		return sb.toString();
	}

	public static DiGraph createTinyDG() {
		DiGraph diGraph = new DiGraph(13);
		diGraph.addEdge(4, 2);
		diGraph.addEdge(2, 3);
		diGraph.addEdge(3, 2);
		diGraph.addEdge(6, 0);
		diGraph.addEdge(0, 1);
		diGraph.addEdge(2, 0);
		diGraph.addEdge(11, 12);
		diGraph.addEdge(12, 9);
		diGraph.addEdge(9, 10);
		diGraph.addEdge(9, 11);
		diGraph.addEdge(8, 9);
		diGraph.addEdge(10, 12);
		diGraph.addEdge(11, 4);
		diGraph.addEdge(4, 3);
		diGraph.addEdge(3, 5);
		diGraph.addEdge(7, 8);
		diGraph.addEdge(8, 7);
		diGraph.addEdge(5, 4);
		diGraph.addEdge(0, 5);
		diGraph.addEdge(6, 4);
		diGraph.addEdge(6, 9);
		diGraph.addEdge(7, 6);
		return diGraph;
	}

	public static DiGraph createTinyDG2() {
		DiGraph diGraph = new DiGraph(13);
		diGraph.addEdge(2, 3);
		diGraph.addEdge(0, 6);
		diGraph.addEdge(0, 1);
		diGraph.addEdge(2, 0);
		diGraph.addEdge(11, 12);
		diGraph.addEdge(9,12 );
		diGraph.addEdge(9, 10);
		diGraph.addEdge(9, 11);
		diGraph.addEdge(3, 5);
		diGraph.addEdge(8, 7);
		diGraph.addEdge(5, 4);
		diGraph.addEdge(0, 5);
		diGraph.addEdge(6, 4);
		diGraph.addEdge(6, 9);
		diGraph.addEdge(7, 6);
		return diGraph;
	}

	public static void main(String[] args) {
		DiGraph tinyDG = DiGraph.createTinyDG();
		System.out.println(tinyDG);
		System.out.println(tinyDG.reverse().reverse());

	}

}
