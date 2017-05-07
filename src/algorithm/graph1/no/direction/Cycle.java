package algorithm.graph1.no.direction;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Cycle {

  private boolean[] marked;
  private boolean hasCycle;
  Graph g;

  public Cycle(Graph g) {
    this.g = g;
    this.marked = new boolean[g.vNum()];
    for (int s = 0; s < g.vNum() && !this.hasCycle; s++) {
      if (!this.marked[s]) {
        Map<Integer, Integer> lastMap = new HashMap<>();
        // this.dfs(s, lastMap);
        // this.bfs(s);
      }
    }

  }

  private void dfs(int v, Map<Integer, Integer> lastMap) {
    if (this.hasCycle) {
      return;
    }
    this.marked[v] = true;
    Set<Integer> set = g.adj(v);
    for (Integer w : set) {
      if (!this.marked[w]) {
        lastMap.put(w, v);
        this.dfs(w, lastMap);
      } else if (this.marked[w] && lastMap.containsKey(v)
          && w != lastMap.get(v)) {
        this.hasCycle = true;
        break;
      }
    }
  }

  private void bfs(int s) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    Map<Integer, Integer> lastMap = new HashMap<>();
    while (!queue.isEmpty()) {
      Integer v = queue.poll();
      this.marked[v] = true;
      Set<Integer> set = g.adj(v);
      for (Integer w : set) {
        if (!this.marked[w]) {
          this.marked[w] = true;
          lastMap.put(w, v);
          queue.add(w);
        } else if (this.marked[w] && lastMap.containsKey(v)
            && w.intValue() != lastMap.get(v).intValue()) {
          this.hasCycle = true;
          return;
        }
      }
    }
  }

  public boolean hasCycle() {
    return this.hasCycle;
  }

  public static void main(String[] args) {
    // Graph g2 = Graph.createTinyCG2();
    // Cycle cycle = new Cycle(g2);
    // System.out.println(cycle.hasCycle);

    Graph g3 = Graph.createTinyCG3();
    Cycle cycle3 = new Cycle(g3);
    System.out.println(cycle3.hasCycle);

  }

}
