package leetcode13.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Exam_100 {

	public static void main(String[] args) {

		Random r = new Random();
		int N = 100;
		Point[] a = new Point[N];
		for (int i = 0; i < N; i++) {
			a[i] = new Point(r.nextInt(10), r.nextInt(10));
		}
		System.out.println(getMostPointLine(a));

	}

	public static Line getMostPointLine(Point[] ps) {
		if (ps == null || ps.length < 2) {
			return null;
		}
		HashMap<Line, HashSet<Point>> map = new HashMap<>();
		int maxP = 0;
		Line result = null;
		for (int i = 0; i < ps.length - 1; i++) {
			for (int j = i + 1; j < ps.length; j++) {
				if (ps[i].equals(ps[j])) {
					continue;
				}
				Line line = new Line(ps[i], ps[j]);

				if (!map.containsKey(line)) {
					map.put(line, new HashSet<Point>());
				} 

				map.get(line).add(ps[i]);
				map.get(line).add(ps[j]);
				int count = map.get(line).size();
				if (count > maxP) {
					maxP = count;
					result = line;
					System.out.println(maxP +"\t"+result + "\t" + map.get(line)); 
				}
			}
		}  
 		return result;
	}

}

class Line {
	final static double epsilon = 0.0001;
	double slope;
	double intercept;
	boolean infiniteSlope;

	public Line(Point p1, Point p2) {
		if (Math.abs(p1.x - p2.x) <= epsilon) {
			if (p1.y == p2.y) {
				throw new RuntimeException("error");
			}
			this.infiniteSlope = true;
			this.slope = 0;
			this.intercept = p1.x;
		} else {
			this.infiniteSlope = false;
			this.slope = (p1.y - p2.y) / (p1.x - p2.x);
			this.intercept = -this.slope * p1.x + p1.y;
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (infiniteSlope ? 1231 : 1237);
		int temp = (int) intercept * 1000;
		result = prime * result + (temp ^ (temp >>> 32));
		temp = (int) slope * 1000;
		result = prime * result + (temp ^ (temp >>> 32));
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
		Line other = (Line) obj;
		if (infiniteSlope != other.infiniteSlope)
			return false;
		if (Math.abs(this.slope - other.slope) > epsilon)
			return false;
		if (Math.abs(this.intercept - other.intercept) > epsilon)
			return false;
		return true;
	}

	 

	@Override
	public String toString() {
		return "Line [" + slope + ", " + intercept
				+ ", " + infiniteSlope +   "]";
	}

 

}

class Point {
	double x;
	double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point(" + x + ", " + y + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
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
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

}
