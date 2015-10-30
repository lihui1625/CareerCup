package algorithm.graph1.no.direction;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DegreeOfSeparation {

	public static void main(String[] args) throws IOException {
		SymbolGraph symbolGraph = new SymbolGraph("d:\1.txt");
		
		Graph graph = symbolGraph.getGraph();
		
		Map<String, Integer> name2Index = symbolGraph.getName2Index();
		
		String filmName1 = "aaaaaaa";
		if(!name2Index.containsKey(filmName1)){
			return;
		}
		
		int filmIndex1 = name2Index.get(filmName1);
		
		String filmName2 = "bbbbbb";
		if(!name2Index.containsKey(filmName2)){
			return;
		}
		
		int filmIndex2 = name2Index.get(filmName2);
		
		List<Integer> path = BreadthFirstPaths.pathTo(graph, filmIndex1, filmIndex2);
		
		System.out.println(path);

	}

}
