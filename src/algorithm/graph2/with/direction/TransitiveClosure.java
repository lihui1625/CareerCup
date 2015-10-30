package algorithm.graph2.with.direction;

public class TransitiveClosure {

	private DirectedDFS[] allDirectedDFS;
	private DiGraph g;
	
	public TransitiveClosure(DiGraph g){
		this.g= g;
		for(int v=0; v<g.vNum();v++){
			allDirectedDFS[v] = new DirectedDFS(g);
			allDirectedDFS[v].bfs(v);
		}
	}
	
	public boolean isReachable(int v, int w){
		return this.allDirectedDFS[v].isMarked(w);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
