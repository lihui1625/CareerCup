package algorithm.graph4.shortest.path;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class DijkstraSP {
  private EdgeWeightedDigraph g;
  private DirectedEdge[] edgeTo;
  private double[] distTo;
  private TreeMap<Double, HashSet<Integer>> dist2VMap;

  public DijkstraSP(EdgeWeightedDigraph g, int start) {
    this.g = g;
    edgeTo = new DirectedEdge[g.vNum()];
    distTo = new double[g.vNum()];
    dist2VMap = new TreeMap<>();
    for (int i = 0; i < g.vNum(); i++) {
      distTo[i] = Double.POSITIVE_INFINITY;
    }

    distTo[start] = 0d;
    dist2VMap.put(distTo[start], new HashSet<Integer>());
    dist2VMap.get(distTo[start]).add(start);

    while (!dist2VMap.isEmpty()) {
      Double firstDist = dist2VMap.firstEntry().getKey();
      HashSet<Integer> fisrtVSet = dist2VMap.firstEntry().getValue();
      if (!fisrtVSet.isEmpty()) {
        Integer v = (Integer) fisrtVSet.toArray()[0];
        fisrtVSet.remove(v);
        this.relax(v);
      }
      if (fisrtVSet.isEmpty()) {
        dist2VMap.remove(firstDist);
      }
    }
  }

  private void relax(int v) {
    Set<DirectedEdge> edgeSet = g.getEdge(v);
    for (DirectedEdge edge : edgeSet) {
      int w = edge.to();

      if (distTo[v] + edge.weight() < distTo[w]) {

        double oldDist = distTo[w];
        edgeTo[w] = edge;
        distTo[w] = distTo[v] + edge.weight();
        double newDist = distTo[w];

        if (dist2VMap.containsKey(oldDist)) {
          dist2VMap.get(oldDist).remove(w);
        }
        if (!dist2VMap.containsKey(newDist)) {
          dist2VMap.put(newDist, new HashSet<Integer>());
        }
        dist2VMap.get(newDist).add(w);
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

  public static void main(String[] args) {
    EdgeWeightedDigraph ewd = EdgeWeightedDigraph.createTinyEWD();
    System.out.println(ewd);
    int start = 0;
    DijkstraSP sp = new DijkstraSP(ewd, start);
    for (int i = 0; i < ewd.vNum(); i++) {
      System.out.println(
          start + " -> " + i + ":" + sp.pathTo(i) + " , len: " + sp.distTo(i));
    }
  }

}
