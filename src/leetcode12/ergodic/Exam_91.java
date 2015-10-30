package leetcode12.ergodic;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Exam_91 {
	
	public int getGraphPaths(GraphNode a, GraphNode b, int n){
		Queue<GraphNode> currQue = new LinkedList<>();
		currQue.add(a);
		int count = 0;
		int steps = 0;
		while(currQue.size()>0 && steps <= n){
			Queue<GraphNode> nextQue = new LinkedList<>();
			steps++;
			while(currQue.size()>0){
				GraphNode node = currQue.poll();
				for(GraphNode next : node.nexts){
					if(next==b && steps==n){
						count++;
					}
					nextQue.add(node);
				}
			}
			currQue.clear();
			currQue.addAll(nextQue);
		}		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class GraphNode{
	int val;
	List<GraphNode> nexts;
}