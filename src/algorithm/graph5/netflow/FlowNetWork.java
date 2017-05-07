package algorithm.graph5.netflow;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class FlowNetWork {

  private final int vNum;
  private int eNum;
  private Map<Integer, LinkedHashSet<FlowEdge>> adj;

  public FlowNetWork(int vNum) {
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

  public void addEdge(int v, int w, double capacity) {
    if (v < 0 || v > this.vNum) {
      return;
    }
    if (w < 0 || w > this.vNum) {
      return;
    }
    if (!this.adj.containsKey(v)) {
      this.adj.put(v, new LinkedHashSet<FlowEdge>());
    }
    FlowEdge d = new FlowEdge(v, w, capacity);
    if (!this.adj.get(v).contains(d)) {
      this.adj.get(v).add(d);
      this.eNum++;
    }
  }

  @SuppressWarnings("unchecked")
  public Set<FlowEdge> getEdge(int v) {
    Set<FlowEdge> set = this.adj.get(v);
    return set == null ? Collections.EMPTY_SET : set;
  }

  public LinkedHashSet<FlowEdge> getAllEdges() {
    LinkedHashSet<FlowEdge> allEdges = new LinkedHashSet<>();
    for (LinkedHashSet<FlowEdge> edges : this.adj.values()) {
      allEdges.addAll(edges);
    }

    return allEdges;
  }

  public boolean localEq(int v) {
    double EPSILON = 1e-11;
    double netflow = 0.0;
    for (FlowEdge fe : this.adj.get(v)) {
      if (v == fe.from()) {
        netflow -= fe.flow();
      } else {
        netflow += fe.flow();
      }
    }
    return Math.abs(netflow) < EPSILON;
  }

  public boolean isFeasible(int start, int terminate) {
    for (int v = 0; v < this.vNum; v++) {
      for (FlowEdge fe : this.adj.get(v)) {
        if (fe.flow() < 0 || fe.flow() > fe.capacity()) {
          return false;
        }
      }
    }
    for (int v = 0; v < this.vNum; v++) {
      if (v != start && v != terminate && !this.localEq(v)) {
        return false;
      }
    }

    return true;
  }

  @Override
  public String toString() {
    return "FlowNetWork [vNum=" + vNum + ", eNum=" + eNum + ", adj=" + adj
        + "]";
  }

  public static FlowNetWork createTinyFN() {
    FlowNetWork fn = new FlowNetWork(6);
    fn.addEdge(0, 1, 2);
    fn.addEdge(0, 2, 3);
    fn.addEdge(1, 3, 3);
    fn.addEdge(1, 4, 1);
    fn.addEdge(2, 3, 1);
    fn.addEdge(2, 4, 1);
    fn.addEdge(3, 5, 2);
    fn.addEdge(4, 5, 3);

    return fn;

  }

  public static void main(String[] args) {
    FlowNetWork fn = FlowNetWork.createTinyFN();
    System.out.println(fn);

  }

}
