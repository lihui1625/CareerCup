package leetcode10.doublepointer;

import java.util.Arrays;
import java.util.Random;

public class Exam_67 {

  public static int fsl(int[] a) {
    if (a == null || a.length == 0) {
      return -1;
    }
    boolean[] islargerThanLeft = new boolean[a.length];
    int max = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
        islargerThanLeft[i] = true;
      }
    }

    int min = a[a.length - 1];
    for (int i = a.length - 2; i >= 0; i--) {
      if (a[i] <= min) {
        min = a[i];
        if (islargerThanLeft[i]) {
          System.out.println("a[" + i + "]=" + a[i]
              + " is larger than left, less than or equal to right");
          return a[i];
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Random r = new Random();
    int N = 4;
    int[] im = new int[N];
    for (int i = 0; i < N; i++) {
      im[i] = r.nextInt(2);
    }
    im = new int[] { 1, 0, 1, 0, 1, 2, 3 };
    System.out.println(Arrays.toString(im));
    System.out.println(fsl(im));

  }

}
