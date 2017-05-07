package algorithm.graph4.shortest.path;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraAllPairSP {

  private Map<Integer, DijkstraSP> allPath;

  public DijkstraAllPairSP(EdgeWeightedDigraph g) {
    super();
    this.allPath = new HashMap<>();
    for (int v = 0; v < g.vNum(); v++) {
      allPath.put(v, new DijkstraSP(g, v));
    }
  }

  public double distTo(int v, int w) {
    return allPath.get(v).distTo(w);
  }

  public List<DirectedEdge> pathTo(int v, int w) {
    return allPath.get(v).pathTo(w);
  }

  public static void main(String[] args) {
    EdgeWeightedDigraph ewd = EdgeWeightedDigraph.createTinyEWD();
    System.out.println(ewd);
    DijkstraAllPairSP sp = new DijkstraAllPairSP(ewd);
    for (int start = 0; start < ewd.vNum(); start++) {
      for (int end = 0; end < ewd.vNum(); end++) {
        System.out.println(start + " -> " + end + ":" + sp.pathTo(start, end)
            + " , len: " + sp.distTo(start, end));
      }
    }
  }

}
