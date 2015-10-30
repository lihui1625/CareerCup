package algorithm.graph3.mst;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class PrimMST {

	private EdgeWeightedGraph g;
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private TreeMap<Double, HashSet<Integer>> dist2VMap;
	private List<Edge> mst;
	private double totalWeight;
 
	public PrimMST(EdgeWeightedGraph eg, int start) {
		super();
		this.g = eg;
 		edgeTo = new Edge[eg.vNum()];
		distTo = new double[eg.vNum()];
		marked = new boolean[eg.vNum()]; 
		dist2VMap = new TreeMap<>();

		for (int i = 0; i < eg.vNum(); i++) {
			distTo[i] = Double.POSITIVE_INFINITY;
		}

		distTo[start] = 0d; 
		dist2VMap.put(distTo[start], new HashSet<Integer>());
		dist2VMap.get(distTo[start]).add(start);

		while (!dist2VMap.isEmpty()) {
			Double firstDist = dist2VMap.firstEntry().getKey();
			HashSet<Integer> firstVset = dist2VMap.firstEntry().getValue();
			if (!firstVset.isEmpty()) {
				Integer v = (Integer) firstVset.toArray()[0];
				firstVset.remove(v);
				visit(v);
			}
			if (firstVset.isEmpty()) {
				dist2VMap.remove(firstDist);
			}
		}
		
		mst = new LinkedList<>();
		for (int i = 0; i < eg.vNum(); i++) {

			if (edgeTo[i] != null) {
				mst.add(edgeTo[i]);
				totalWeight += edgeTo[i].weight();
				//totalWeight += distTo[i] ;
			}
		}

	}

	private void visit(int v) {		
		marked[v] = true;
		Set<Edge> edgeSet = g.getEdge(v);
		for (Edge edge : edgeSet) {
			int w = edge.otherVertex(v);
			if (marked[w]) {
				continue;
			}

			if (distTo[w] > edge.weight()) {

				double oldDist = distTo[w];
				edgeTo[w] = edge;
				distTo[w] = edge.weight();
				double newDist = distTo[w];

				if (dist2VMap.containsKey(oldDist)) {
					 dist2VMap.get(oldDist).remove(w); 
				}				
				if (!dist2VMap.containsKey(newDist)) {
					dist2VMap.put(newDist, new HashSet<Integer>());
				}
				dist2VMap.get(newDist).add(w);
			}
		}
	}

	public List<Edge> mst() {
		return mst;
	}

	public double totalWeight() {
		return totalWeight;
	}

	@Override
	public String toString() {
		return "LazyPrimMST [mst=" + mst + ", totalWeight=" + totalWeight + "]";
	}

	public static void main(String[] args) {
		EdgeWeightedGraph eg = EdgeWeightedGraph.createTinyGC();
		System.out.println(eg);
		PrimMST lp = new PrimMST(eg, 5);
		System.out.println(lp);

	}

}
