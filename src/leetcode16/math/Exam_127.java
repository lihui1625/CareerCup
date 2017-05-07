package leetcode16.math;

import java.util.LinkedList;
import java.util.List;

public class Exam_127 {

  public static boolean isJH(int n) {
    LinkedList<Integer> list = new LinkedList<>();
    while (n > 0) {
      int num = n % 10;
      n = n / 10;
      list.addFirst(num);
    }
    System.out.println(list);
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isJH(12312312));
    System.out.println(isJH(6456));
    System.out.println(isJH(7453245));
    System.out.println(isJH(976766045));
    System.out.println(isJH(54078532));

  }

}
