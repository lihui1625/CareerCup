package algorithm.graph4.shortest.path;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EdgeWeightedDepthFirstOrder {

	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	private EdgeWeightedDigraph g;

	public EdgeWeightedDepthFirstOrder(EdgeWeightedDigraph g) {
		this.g = g;
		this.marked = new boolean[g.vNum()];
		this.pre = new LinkedList<>();
		this.post = new LinkedList<>();
		this.reversePost = new Stack<>();
		for (int i = 0; i < g.vNum(); i++) {
			if (!this.marked[i]) {
				this.dfs(i);
			}
		}
	}

	private void dfs(int start) {
		 
	}
	
	

	public Queue<Integer> getPre() {
		return pre;
	}

	public Queue<Integer> getPost() {
		return post;
	}

	public Stack<Integer> getReversePost() {
		return reversePost;
	}

	public static void main(String[] args) {
		EdgeWeightedDigraph tinyDG  = EdgeWeightedDigraph.createTinyEWD();
		EdgeWeightedDepthFirstOrder depthFirstOrder = new EdgeWeightedDepthFirstOrder(tinyDG);
		System.out.println("pre:" + depthFirstOrder.getPre());
		System.out.println("post:" + depthFirstOrder.getPost());
		System.out.println("reversePost" + depthFirstOrder.getReversePost());

	}

}
