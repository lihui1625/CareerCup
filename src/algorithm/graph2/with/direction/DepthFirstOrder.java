package algorithm.graph2.with.direction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DepthFirstOrder {

	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	private DiGraph g;

	public DepthFirstOrder(DiGraph g) {
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
		this.pre.add(start);
		this.marked[start] = true;
		Set<Integer> adjSet= this.g.adj(start);
		for(Integer v:adjSet){
			if(!this.marked[v]){
				this.dfs(v);
			}
		}

		this.post.add(start);
		this.reversePost.push(start);

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
		DiGraph tinyDG  = DiGraph.createTinyDG();
		DepthFirstOrder depthFirstOrder = new DepthFirstOrder(tinyDG);
		System.out.println("pre:" + depthFirstOrder.getPre());
		System.out.println("post:" + depthFirstOrder.getPost());
		System.out.println("reversePost" + depthFirstOrder.getReversePost());

	}

}
