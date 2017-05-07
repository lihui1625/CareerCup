package leetcode16.math;

import java.util.Arrays;
import java.util.Random;

public class Exam_129 {

  public static int[] random(int[] A, int k) {
    int[] b = new int[k];
    Random r = new Random();
    for (int i = 0; i < A.length; i++) {
      if (i < k) {
        b[i] = A[i];
      } else {
        int index = r.nextInt(k);
        b[index] = A[i];
      }
    }

    return b;
  }

  public static void main(String[] args) {
    int[] a = { 12, 423, 6, 34544, 89, 456, 435, 53, 345, 6, 344, 325, 8, 6, 67,
        54, 8, 87, 57, 63, 34, 5, 54654, 54 };
    System.out.println(Arrays.toString(random(a, 3)));

  }

}
