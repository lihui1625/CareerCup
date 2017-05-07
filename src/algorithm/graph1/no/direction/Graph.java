package algorithm.graph1.no.direction;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph {

  private final int vNum;
  private int eNum;
  private Map<Integer, Set<Integer>> edges;

  public Graph(int vNum) {
    this.vNum = vNum;
    this.eNum = 0;
    edges = new LinkedHashMap<Integer, Set<Integer>>();
    for (int v = 0; v < this.vNum; v++) {
      this.edges.put(v, new LinkedHashSet<Integer>());
    }
  }

  public Graph(FileReader in) throws IOException {
    this(in.read());
    this.eNum = in.read();
    for (int i = 0; i < this.eNum; i++) {
      int v = in.read();
      int w = in.read();
      this.addEdge(v, w);
    }
    in.close();
  }

  public int vNum() {
    return this.vNum;
  }

  public int eNum() {
    return this.eNum;
  }

  public void addEdge(int v, int w) {
    if (v == w || v < 0 || v >= this.vNum || w < 0 || w >= this.vNum) {
      return;
    }
    this.edges.get(v).add(w);
    this.edges.get(w).add(v);
    eNum++;
  }

  public Set<Integer> adj(int v) {
    return this.edges.get(v);
  }

  public Map<Integer, Set<Integer>> allEdges() {
    return this.edges;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Graph [vNum=" + vNum + ", eNum=" + eNum + "]:\n");
    Set<Entry<Integer, Set<Integer>>> entrySet = this.edges.entrySet();
    for (Entry<Integer, Set<Integer>> entry : entrySet) {
      sb.append(entry.getKey() + " --> " + entry.getValue() + "\n");
    }
    return sb.toString();
  }

  public int degree(int v) {
    Set<Integer> s = adj(v);
    return s.size();
  }

  public int maxDegree() {
    int max = 0;
    Set<Integer> keySet = allEdges().keySet();
    for (Integer v : keySet) {
      max = Math.max(max, degree(v));
    }
    return max;
  }

  public double avgDegree() {

    return 2.0 * eNum() / (vNum() * 1.0);
  }

  public static Graph createTinyCG() {
    Graph g = new Graph(13);
    g.addEdge(0, 5);
    g.addEdge(4, 3);
    g.addEdge(0, 1);
    g.addEdge(9, 12);
    g.addEdge(6, 4);
    g.addEdge(5, 4);
    g.addEdge(0, 2);
    g.addEdge(11, 12);
    g.addEdge(9, 10);
    g.addEdge(0, 6);
    g.addEdge(7, 8);
    g.addEdge(9, 11);
    g.addEdge(5, 3);
    return g;
  }

  public static Graph createTinyCG2() {
    Graph g = new Graph(6);
    g.addEdge(0, 5);
    g.addEdge(2, 4);
    g.addEdge(2, 3);
    g.addEdge(1, 2);
    g.addEdge(0, 1);
    g.addEdge(3, 4);
    g.addEdge(3, 5);
    g.addEdge(0, 2);
    return g;
  }

  public static Graph createTinyCG3() {
    Graph g = new Graph(8);
    g.addEdge(0, 1);
    g.addEdge(1, 4);
    return g;
  }

  public static void main(String[] args) {
    Graph g = Graph.createTinyCG();
    System.out.println(g);
    System.out.println("vNum:" + g.vNum());
    System.out.println("eNum:" + g.eNum());
    System.out.println("adj 0 :" + g.adj(0));
    System.out.println("adj 1 :" + g.adj(1));
    System.out.println("adj 2 :" + g.adj(2));
    System.out.println("adj 3 :" + g.adj(3));
    System.out.println("adj 4 :" + g.adj(4));
    System.out.println("degree 0 :" + g.degree(0));
    System.out.println("degree 1 :" + g.degree(1));
    System.out.println("degree 2 :" + g.degree(2));
    System.out.println("degree 3 :" + g.degree(3));
    System.out.println("degree 4 :" + g.degree(4));
    System.out.println("maxDegree :" + g.maxDegree());
    System.out.println("avgDegree :" + g.avgDegree());

  }

}
