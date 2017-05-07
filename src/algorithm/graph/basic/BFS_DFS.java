package algorithm.graph.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BFS_DFS {

  private final List<String> vertexes = new ArrayList<String>();
  private final Map<String, List<String>> linkTable = new TreeMap<String, List<String>>();

  public List<String> getVertexes() {
    return vertexes;
  }

  public void addVertexes(String vertex) {
    if (!this.vertexes.contains(vertex.trim())) {
      this.vertexes.add(vertex.trim());
    }
  }

  public void removeVertexes(String vertex) {
    this.vertexes.remove(vertex.trim());
    linkTable.remove(vertex.trim());
    for (Map.Entry<String, List<String>> en : this.linkTable.entrySet()) {
      Iterator<String> iterator = en.getValue().iterator();
      while (iterator.hasNext()) {
        String next = iterator.next();
        if (next.trim().equals(vertex)) {
          iterator.remove();
        }
      }
    }
  }

  public void addEdge(String from, String to) {
    if (!this.vertexes.contains(from) || !this.vertexes.contains(to)) {
      return;
    }
    List<String> toSet = this.linkTable.get(from);
    if (toSet == null) {
      toSet = new ArrayList<>();
      this.linkTable.put(from, toSet);
    }
    if (!toSet.contains(to)) {
      toSet.add(to);
    }
  }

  public void addDoubleEdge(String from, String to) {
    this.addEdge(from, to);
    this.addEdge(to, from);
  }

  public void removeEdge(String from, String to) {
    if (!this.vertexes.contains(from) || !this.vertexes.contains(to)) {
      return;
    }
    List<String> toSet = this.linkTable.get(from);
    if (toSet != null) {
      toSet.remove(to);
    }
  }

  @Override
  public String toString() {
    String str = "";
    for (Map.Entry<String, List<String>> en : this.linkTable.entrySet()) {
      str += en.getKey() + " -> [ ";
      Iterator<String> iterator = en.getValue().iterator();
      while (iterator.hasNext()) {
        String next = iterator.next();
        str += next + "  ";
      }
      str += " ]\n";
    }
    return "UnweightedGraph{\n" + str + '}';
  }

  // 深度优先
  public List<String> dfs() {
    if (this.vertexes.isEmpty()) {
      return Collections.emptyList();
    }
    List<String> results = new ArrayList<>();
    Stack<String> stack = new Stack<>();
    String first = this.getVertexes().get(0);

    results.add(first);
    stack.push(first);

    while (!stack.isEmpty()) {
      String top = stack.peek();
      List<String> linkedVertexes = this.linkTable.get(top);
      String notVisited = null;
      if (linkedVertexes != null) {
        for (String s : linkedVertexes) {
          if (!results.contains(s)) {
            notVisited = s;
            break;
          }
        }
      }
      if (notVisited == null) {
        stack.pop();
      } else {
        results.add(notVisited);
        stack.push(notVisited);
      }

    }
    return results;
  }

  // 广度优先
  public List<String> bfs() {
    if (this.vertexes.isEmpty()) {
      return Collections.emptyList();
    }
    List<String> results = new ArrayList<>();
    Queue<String> queue = new LinkedList<>();
    String first = this.getVertexes().get(0);

    results.add(first);
    queue.add(first);

    while (!queue.isEmpty()) {
      String top = queue.peek();

      List<String> linkedVertexes = this.linkTable.get(top);
      String notVisited = null;
      if (linkedVertexes != null) {
        for (String s : linkedVertexes) {
          if (!results.contains(s)) {
            notVisited = s;
            break;
          }
        }
      }
      if (notVisited == null) {
        queue.poll();
      } else {
        results.add(notVisited);
        queue.add(notVisited);
      }

    }
    return results;
  }

  public static void main(String[] args) {
    BFS_DFS g = new BFS_DFS();
    g.addVertexes("a");
    g.addVertexes("b");
    g.addVertexes("c");
    g.addVertexes("d");
    g.addVertexes("e");

    g.addDoubleEdge("a", "b");
    g.addDoubleEdge("a", "c");
    g.addDoubleEdge("b", "e");
    g.addDoubleEdge("b", "d");
    g.addDoubleEdge("c", "d");
    g.addDoubleEdge("d", "e");

    System.out.println(g.toString());

    List<String> dfs = g.dfs();
    System.out.println(dfs.toString());

    List<String> bfs = g.bfs();
    System.out.println(bfs.toString());

  }

}