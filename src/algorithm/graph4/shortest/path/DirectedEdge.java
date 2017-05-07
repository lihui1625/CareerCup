package algorithm.graph4.shortest.path;

public class DirectedEdge {

  private final int v;
  private final int w;
  private final double weight;

  public DirectedEdge(int v, int w, double weight) {
    super();
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public int from() {
    return this.v;
  }

  public int to() {
    return this.w;
  }

  public double weight() {
    return this.weight;
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
    DirectedEdge other = (DirectedEdge) obj;
    if (v != other.v)
      return false;
    if (w != other.w)
      return false;
    if (Double.doubleToLongBits(weight) != Double
        .doubleToLongBits(other.weight))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "(" + v + "-->" + w + "," + weight + ")";
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
