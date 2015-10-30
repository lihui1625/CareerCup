package algorithm.graph4.shortest.path;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Topological {
	
 	private EdgeWeightedDirectedCycle directedCycle;
	private EdgeWeightedDepthFirstOrder depthFirstOrder;
	private Queue<Integer> order;
	
	public Topological(EdgeWeightedDigraph g){
 		this.directedCycle = new EdgeWeightedDirectedCycle(g);
		this.depthFirstOrder = new EdgeWeightedDepthFirstOrder(g);
		Stack<Integer> reversePost = this.depthFirstOrder.getReversePost();
		this.order = new LinkedList<>();
		while(!reversePost.isEmpty()){
			this.order.add(reversePost.pop());
		}
	}
	
	public Queue<Integer> order(){
		return this.order;
	}
	
	public boolean isDAG(){
		return this.directedCycle.hasCycle();
	}
	

	public static void main(String[] args) {
		EdgeWeightedDigraph tinyDG = EdgeWeightedDigraph.createTinyEWD();
		System.out.println(tinyDG);
		Topological topological = new Topological(tinyDG);
		System.out.println(topological.order());

	}

}
