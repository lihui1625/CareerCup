package algorithm.graph4.shortest.path;

import java.util.Random;

public class CPM {

  public static void main(String[] args) {
    Random r = new Random();
    int N = 1000;
    EdgeWeightedDigraph eg = new EdgeWeightedDigraph(2 * N + 2);
    int s = 2 * N;
    int t = 2 * N + 1;
    for (int i = 0; i < N; i++) {
      double duration = r.nextDouble();
      eg.addEdge(i, i + N, duration);
      eg.addEdge(s, i, 0d);
      eg.addEdge(i + N, 1, 0d);

      for (int j = i; j < 10; j++) {
        int successor = r.nextInt(100);
        eg.addEdge(i + N, successor, 0d);
      }
    }
    AcyclicSP lp = new AcyclicSP(eg, s);
    System.out.println("Start:");
    for (int i = 0; i < N; i++) {
      System.out.println(i + ":" + lp.distTo(i));
    }
    System.out.println("Finish:" + lp.distTo(t));

  }
}
