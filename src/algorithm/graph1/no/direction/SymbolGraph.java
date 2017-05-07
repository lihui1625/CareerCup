package algorithm.graph1.no.direction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SymbolGraph {

  private Map<String, Integer> name2Index;
  private Set<String> keys;
  private Graph g;

  public SymbolGraph(String stream) throws IOException {
    name2Index = new LinkedHashMap<>();
    keys = new LinkedHashSet<>();
    java.io.BufferedReader in = new BufferedReader(new FileReader(stream));

    String line = null;
    while ((line = in.readLine()) != null) {

      String[] array = line.split(",");

      for (int i = 0; i < array.length; i++) {
        if (!this.name2Index.containsKey(array[i])) {
          this.name2Index.put(array[i], this.name2Index.size());
          keys.add(array[i]);
        }
      }
      int v = name2Index.get(array[0]);
      for (int i = 0; i < array.length; i++) {
        this.g.addEdge(v, name2Index.get(array[i]));
      }

    }
    in.close();
    this.g = new Graph(name2Index.size());

  }

  public Map<String, Integer> getName2Index() {
    return name2Index;
  }

  public Set<String> getNames() {
    return keys;
  }

  public Graph getGraph() {
    return g;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
