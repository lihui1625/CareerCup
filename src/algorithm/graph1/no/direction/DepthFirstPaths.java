package algorithm.graph1.no.direction;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DepthFirstPaths {

  private static void dfs1(Graph g, int start, Map<Integer, Integer> lastMap) {
    Set<Integer> set = g.adj(start);
    for (int v : set) {
      if (!lastMap.containsKey(v)) {
        lastMap.put(v, start);
        dfs1(g, v, lastMap);
      }
    }
  }

  public static List<Integer> pathTo(Graph g, int start, int end) {

    LinkedList<Integer> path = new LinkedList<>();
    if (!g.allEdges().containsKey(start) || !g.allEdges().containsKey(end)) {
      return null;
    }

    if (start == end) {
      path.add(start);
      return path;
    }

    Map<Integer, Integer> lastMap = new HashMap<>();
    lastMap.put(start, null);
    dfs1(g, start, lastMap);

    if (!lastMap.containsKey(end)) {
      return null;
    }

    for (Integer v = end; v != null; v = lastMap.get(v)) {
      path.addFirst(v);
    }

    return path;
  }

  public static List<Integer> pathTo2(Graph g, int start, int end) {

    LinkedList<Integer> path = new LinkedList<>();
    if (!g.allEdges().containsKey(start) || !g.allEdges().containsKey(end)) {
      return null;
    }

    if (start == end) {
      path.add(start);
      return path;
    }

    Set<Integer> hasVisted = new LinkedHashSet<>();
    Stack<Integer> stack = new Stack<Integer>();
    Map<Integer, Integer> lastMap = new HashMap<>();
    stack.push(start);
    boolean isBreak = false;
    while (!stack.isEmpty()) {
      Integer v = stack.peek();
      if (!hasVisted.contains(v)) {
        hasVisted.add(v);
      }
      Set<Integer> set = g.adj(v);
      boolean toRemove = true;
      for (Integer w : set) {
        if (!hasVisted.contains(w)) {
          stack.push(w);
          lastMap.put(w, v);
          toRemove = false;
          if (w.intValue() == end) {
            isBreak = true;
            break;
          }
        }
      }
      if (toRemove) {
        stack.pop();
      }
      if (isBreak) {
        break;
      }
    }
    if (!lastMap.containsKey(end)) {
      return null;
    }

    for (Integer v = end; v != null; v = lastMap.get(v)) {
      path.addFirst(v);
    }

    return path;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Graph g = Graph.createTinyCG();
    // System.out.println(g);

    for (Integer k : g.allEdges().keySet()) {
      for (Integer x : g.allEdges().keySet()) {
        System.out.println(k + " --> " + x + ":" + pathTo(g, k, x));
        System.out.println(k + " --> " + x + ":" + pathTo2(g, k, x));
      }
    }

    Graph g2 = Graph.createTinyCG2();
    // System.out.println(g2);

    for (Integer k : g2.allEdges().keySet()) {
      for (Integer x : g2.allEdges().keySet()) {
        System.out.println(k + " --> " + x + ":" + pathTo(g2, k, x));
        System.out.println(k + " --> " + x + ":" + pathTo2(g2, k, x));
      }
    }
  }

}
