package algorithm.graph1.no.direction;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

  public static Set<Integer> dfs1(Graph g, int start) {
    Set<Integer> list = new LinkedHashSet<>();
    dfs1(g, start, list);
    return list;
  }

  private static void dfs1(Graph g, int start, Set<Integer> list) {
    list.add(start);
    Set<Integer> set = g.adj(start);
    for (int v : set) {
      if (!list.contains(v)) {
        dfs1(g, v, list);
      }
    }
  }

  public static Set<Integer> dfs2(Graph g, int start) {

    Set<Integer> list = new LinkedHashSet<>();
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(start);
    while (!stack.isEmpty()) {
      Integer v = stack.peek();
      if (!list.contains(v)) {
        list.add(v);
      }
      Set<Integer> set = g.adj(v);
      boolean toRemove = true;
      for (Integer w : set) {
        if (!list.contains(w)) {
          stack.push(w);
          toRemove = false;
        }
      }
      if (toRemove) {
        stack.pop();
      }
    }
    return list;

  }

  public static void main(String[] args) {
    Graph g = Graph.createTinyCG();
    // System.out.println(g);

    for (Integer k : g.allEdges().keySet()) {
      System.out.println("");
      System.out.println(k + " --> " + DepthFirstSearch.dfs1(g, k));
      System.out.println(k + " --> " + DepthFirstSearch.dfs2(g, k));
    }

    Graph g2 = Graph.createTinyCG2();
    // System.out.println(g2);

    for (Integer k : g2.allEdges().keySet()) {
      System.out.println("");
      System.out.println(k + " --> " + DepthFirstSearch.dfs1(g2, k));
      System.out.println(k + " --> " + DepthFirstSearch.dfs2(g2, k));
    }
  }

}
