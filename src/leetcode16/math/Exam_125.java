package leetcode16.math;

import java.util.HashMap;
import java.util.Random;

public class Exam_125 {
  private static Random r = new Random();

  private static int random7() {

    return r.nextInt(7) + 1;
  }

  public static int random10() {

    int n = Integer.MAX_VALUE;
    while (n > 40) {
      n = random7() + 7 * (random7() - 1); //
    }
    return n % 10 + 1;
  }

  public static void main(String[] args) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < 100000; i++) {
      int rdm = random10();
      if (!map.containsKey(rdm)) {
        map.put(rdm, 0);
      }
      map.put(rdm, map.get(rdm) + 1);
    }
    System.out.println(map);

  }

}
