package leetcode10.doublepointer;

import java.util.Arrays;
import java.util.Random;

public class Exam_65 {

  public static int maxArea(int[] a) {
    int p1 = 0;
    int p2 = a.length - 1;
    int maxArea = 0;
    while (p1 < p2) {
      int thisArea = Math.min(a[p1], a[p2]) * (p2 - p1 + 1);
      System.out.println("" + p1 + "," + p2 + ":" + thisArea);
      maxArea = Math.max(thisArea, maxArea);
      if (a[p1] < a[p2]) {
        p1++;
      } else {
        p2--;
      }
    }
    return maxArea;
  }

  public static void main(String[] args) {
    Random r = new Random();
    int N = 6;
    int[] im = new int[N];
    for (int i = 0; i < N; i++) {
      im[i] = r.nextInt(20);
    }
    System.out.println(Arrays.toString(im));
    System.out.println(maxArea(im));

  }

}
