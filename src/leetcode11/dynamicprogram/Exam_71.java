package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_71 {

  public static int[] maxSubArray(int[] A) {
    if (A == null || A.length == 0)
      return null;
    int sum = A[0];
    int max = sum;
    int start = 0;
    int end = 0;
    int currentStart = start;
    for (int i = 1; i < A.length; i++) {
      if (sum <= 0) {
        currentStart = i;
      }
      sum = sum <= 0 ? A[i] : sum + A[i];
      if (sum > max) {
        start = currentStart;
        end = i;
        max = sum;
      }
    }
    return new int[] { start, end };
  }

  public static void main(String[] args) {

    Random r = new Random();
    int N = 20;
    int[] a1 = new int[N];
    System.out.println();
    for (int i = 0; i < N; i++) {
      a1[i] = r.nextInt(20) - 10;
      System.out.print(a1[i] + ", ");
    }
    System.out.println();
    int re[] = maxSubArray(a1);
    for (int i = re[0]; i <= re[1]; i++) {
      System.out.print(a1[i] + ", ");
    }
  }

}
