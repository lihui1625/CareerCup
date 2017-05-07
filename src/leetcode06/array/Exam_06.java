package leetcode06.array;

import java.util.Arrays;
import java.util.Comparator;

public class Exam_06 {

  public static int getOverlappedCnt(Interval[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    Point[] points = new Point[2 * A.length];
    for (int i = 0; i < A.length; i++) {
      points[2 * i] = new Point(A[i].start, Point.Type.Start);
      points[2 * i + 1] = new Point(A[i].end, Point.Type.End);
    }
    Arrays.sort(points, new Comparator<Point>() {

      @Override
      public int compare(Point o1, Point o2) {
        return o1.value - o2.value;
      }
    });

    int max = 0;
    int count = 1;

    for (int i = 0; i < points.length; i++) {
      if (points[i].type == Point.Type.Start) {
        count++;
        max = Math.max(max, count);
      } else {
        count--;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Interval[] A = new Interval[] { new Interval(1, 5), new Interval(4, 10),
        new Interval(9, 15), new Interval(14, 20), new Interval(19, 25) };
    int cnt = getOverlappedCnt(A);
    System.out.println(cnt);

  }

}

class Interval {
  int start;

  int end;

  public Interval(int start, int end) {
    super();
    this.start = start;
    this.end = end;
  }

  @Override
  public String toString() {
    return "Interval [start=" + start + ", end=" + end + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + end;
    result = prime * result + start;
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
    Interval other = (Interval) obj;
    if (end != other.end)
      return false;
    if (start != other.start)
      return false;
    return true;
  }

}

class Point {

  enum Type {
    Start, End
  }

  int value;
  Type type;

  public Point(int value, Type type) {
    super();
    this.value = value;
    this.type = type;
  }

  @Override
  public String toString() {
    return "Point [value=" + value + ", type=" + type + "]";
  }

}
