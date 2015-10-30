package algorithm.graph2.with.direction;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Topological {
	
	private DiGraph g;
	private DirectedCycle directedCycle;
	private DepthFirstOrder depthFirstOrder;
	private Queue<Integer> order;
	
	public Topological(DiGraph g){
		this.g = g;
		this.directedCycle = new DirectedCycle(g);
		this.depthFirstOrder = new DepthFirstOrder(g);
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
		DiGraph tinyDG = DiGraph.createTinyDG2();
		System.out.println(tinyDG);
		Topological topological = new Topological(tinyDG);
		System.out.println(topological.order());

	}

}
