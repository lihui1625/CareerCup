package algorithm.graph4.shortest.path;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class EdgeWeightedDirectedCycle {

  private boolean[] marked;
  private Map<Integer, Integer> lastV;
  private List<DirectedEdge> cycle;
  private boolean[] onStack;
  private EdgeWeightedDigraph g;

  public EdgeWeightedDirectedCycle(EdgeWeightedDigraph g) {
    this.g = g;
    this.marked = new boolean[g.vNum()];
    this.onStack = new boolean[g.vNum()];
    this.cycle = new LinkedList<>();
    this.lastV = new HashMap<>();
    for (int i = 0; i < g.vNum(); i++) {
      this.dfs(i);
    }
  }

  private void dfs(int start) {

  }

  public boolean hasCycle() {
    return cycle.isEmpty();
  }

  public List<DirectedEdge> getCycle() {
    return this.cycle;
  }

  public static void main(String[] args) {
    EdgeWeightedDigraph tinyDG = EdgeWeightedDigraph.createTinyEWD();
    EdgeWeightedDirectedCycle directedCycle = new EdgeWeightedDirectedCycle(
        tinyDG);
    System.out
        .println(directedCycle.hasCycle() + ":" + directedCycle.getCycle());

  }

}
