package career09.recursion.dynamic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Exam_9_2 {

  public static int X = 10;
  public static int Y = 10;

  public static boolean isFree(int x, int y) {
    if (x < 0 || y < 0 || x > X || y > Y) {
      return false;
    }
    boolean b1 = (x != 0 || y != 6);
    if (!b1) {
      return false;
    }
    b1 = (x != 6 || y != 10);
    if (!b1) {
      return false;
    }
    return true;
  }

  public static boolean getPath(int x, int y, List<Point> points) {
    Point p = new Point(x, y);
    points.add(p);
    if (x == X && y == Y) {
      return true;
    }

    boolean access = false;
    if (y >= 0 && y <= Y && isFree(x, y + 1)) {
      access = getPath(x, y + 1, points);
    }
    if (!access && x >= 0 && x <= X && isFree(x + 1, y)) {
      access = getPath(x + 1, y, points);
    }
    if (!access) {
      points.remove(p);
    }
    return access;
  }

  public static boolean getPath2(int x, int y, List<Point> points,
      HashMap<Point, Boolean> map) {
    Point p = new Point(x, y);
    points.add(p);
    if (x == X && y == Y) {
      return true;
    }
    if (map.containsKey(p)) {
      return map.get(p);
    }

    boolean access = false;
    if (y >= 0 && y <= Y && isFree(x, y + 1)) {
      access = getPath2(x, y + 1, points, map);
    }
    if (!access && x >= 0 && x <= X && isFree(x + 1, y)) {
      access = getPath2(x + 1, y, points, map);
    }
    if (!access) {
      points.remove(p);
    }
    map.put(p, access);
    return access;
  }

  public static void main(String[] args) {
    List<Point> points = new LinkedList<>();
    boolean access = getPath(0, 0, points);
    if (access) {
      System.out.println(" path: " + points);
    } else {
      System.out.println(" can't access ");
    }

    points = new LinkedList<>();
    HashMap<Point, Boolean> map = new HashMap<Point, Boolean>();
    access = getPath2(0, 0, points, map);
    if (access) {
      System.out.println(" path: " + points);
    } else {
      System.out.println(" can't access ");
    }

  }

}

class Point {
  public int x;
  public int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

}