package algorithm.graph3.mst;

public class Edge implements Comparable<Edge> {

	private final int v;
	private final int w;
	private final double weight;

	public Edge(int v, int w, double weight) {
		super();
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public double weight() {
		return this.weight;
	}

	public int oneVertex() {
		return this.v;
	}

	public int otherVertex(int s) {
		if (s == v) {
			return w;
		} else if (s == w) {
			return v;
		}
		throw new RuntimeException("Error");
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight == o.weight ? 0 : (this.weight < o.weight ? -1 : 1);
	}

	@Override
	public String toString() {
		return "{" + v + "--" + w + ", " + weight + "}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + v;
		result = prime * result + w;
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Edge other = (Edge) obj;
		if (v != other.v)
			return false;
		if (w != other.w)
			return false;
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	
}
