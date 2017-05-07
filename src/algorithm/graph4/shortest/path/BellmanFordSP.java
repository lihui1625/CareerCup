package algorithm.graph4.shortest.path;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BellmanFordSP {

  private EdgeWeightedDigraph g;
  private DirectedEdge[] edgeTo;
  private double[] distTo;
  private boolean[] onQ;
  private Queue<Integer> queue;
  private int cost;
  private List<DirectedEdge> cycle;

  public BellmanFordSP(EdgeWeightedDigraph g, int start) {
    this.g = g;
    edgeTo = new DirectedEdge[g.vNum()];
    distTo = new double[g.vNum()];
    onQ = new boolean[g.vNum()];
    queue = new LinkedList<>();
    for (int i = 0; i < g.vNum(); i++) {
      distTo[i] = Double.POSITIVE_INFINITY;
    }

    distTo[start] = 0d;
    queue.add(start);
    onQ[start] = true;
    while (!queue.isEmpty() && !hasNigativeCycle()) {
      int v = queue.poll();
      onQ[v] = false;
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
        if (!onQ[w]) {
          queue.add(w);
          onQ[w] = true;
        }
        if (cost++ % g.vNum() == 0) {
          this.findNigativeCycle();
        }

      }
    }
  }

  public double distTo(int v) {
    return distTo[v];
  }

  public boolean hasPath(int v) {
    return distTo[v] < Double.POSITIVE_INFINITY;
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

  public void findNigativeCycle() {
    int len = this.edgeTo.length;
    EdgeWeightedDigraph childEg = new EdgeWeightedDigraph(len);
    for (int i = 0; i < len; i++) {
      DirectedEdge edge = this.edgeTo[i];
      if (edge != null) {
        childEg.addEdge(edge.from(), edge.to(), edge.weight());
      }
    }
    EdgeWeightedDirectedCycle cf = new EdgeWeightedDirectedCycle(childEg);
    this.cycle = cf.getCycle();

  }

  public boolean hasNigativeCycle() {
    return this.cycle != null || this.cycle.isEmpty();
  }

  public List<DirectedEdge> negetiveCycle() {
    return this.cycle;
  }

}
