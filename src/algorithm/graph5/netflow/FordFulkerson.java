package algorithm.graph5.netflow;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {

	private FlowNetWork g;
	private boolean[] marked;
	private FlowEdge[] edgeTo;
	private double value;

	public FordFulkerson(FlowNetWork g, int start, int terminate) {
		this.g = g;

		while (this.hasAugmentingPath(start, terminate)) {
			double bottle = Double.POSITIVE_INFINITY;
			for (int v = terminate; v != start; v = edgeTo[v].other(v)) {
				bottle = Math.min(bottle, edgeTo[v].residualCapacity(v));
			}
			for (int v = terminate; v != start; v = edgeTo[v].other(v)) {
				edgeTo[v].addResidualFlowTo(v, bottle);
			}
			value += bottle;
		}
	}

	private boolean hasAugmentingPath(int start, int terminate) {
		this.marked = new boolean[g.vNum()];
		this.edgeTo = new FlowEdge[g.vNum()];
		Queue<Integer> queue = new LinkedList<>();

		this.marked[start] = true;
		queue.add(start);
		while (!queue.isEmpty()) {
			int v = queue.poll();
			for (FlowEdge fe : g.getEdge(v)) {
				int w = fe.other(v);
				if (fe.residualCapacity(w) > 0 && !this.marked[w]) {
					this.edgeTo[w] = fe;
					this.marked[w] = true;
					queue.add(w);
				}
			}
		}

		return this.marked[terminate];
	}

	public double value() {
		return this.value;
	}

	public boolean inCut(int v) {
		return this.marked[v];
	}

	public static void main(String[] args) {
		FlowNetWork fn = FlowNetWork.createTinyFN();
		System.out.println(fn);

		FordFulkerson maxFlow = new FordFulkerson(fn, 0, fn.vNum() - 1);

		for (int v = 0; v < fn.vNum(); v++) {
			for (FlowEdge fe : fn.getEdge(v)) {
				if (v == fe.from() && fe.flow() > 0) {
					System.out.println(fe);
				}
			}
		}
		System.out.println("max:" + maxFlow.value());
	}

}
