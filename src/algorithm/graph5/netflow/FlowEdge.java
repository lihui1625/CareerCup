package algorithm.graph5.netflow;

public class FlowEdge {

	final private int v;
	final private int w;
	final private double capacity;
	private double flow;

	public FlowEdge(int v, int w, double capacity) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
		this.flow = 0;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	public double capacity() {
		return this.capacity;
	}

	public double flow() {
		return this.flow;
	}

	public int other(int s) {
		if (s == v) {
			return w;
		} else if (s == w) {
			return v;
		} else {
			throw new RuntimeException("Error");
		}
	}

	public double residualCapacity(int s) {
		if (s == v) {
			return this.flow;
		} else if (s == w) {
			return this.capacity - this.flow;
		} else {
			throw new RuntimeException("Error");
		}
	}

	public void addResidualFlowTo(int s, double delta) {
		if (s == v) {
			this.flow -= delta;
		} else if (s == w) {
			this.flow += delta;
		} else {
			throw new RuntimeException("Error");
		}
	}

	@Override
	public String toString() {
		return "FlowEdge [v=" + v + ", w=" + w + ", capacity=" + capacity
				+ ", flow=" + flow + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(capacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(flow);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + v;
		result = prime * result + w;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlowEdge other = (FlowEdge) obj;
		if (Double.doubleToLongBits(capacity) != Double
				.doubleToLongBits(other.capacity))
			return false;
		if (Double.doubleToLongBits(flow) != Double
				.doubleToLongBits(other.flow))
			return false;
		if (v != other.v)
			return false;
		if (w != other.w)
			return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
