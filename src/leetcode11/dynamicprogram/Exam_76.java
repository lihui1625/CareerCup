package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_76 {

  public static int minCost(int h, int[] colors) {
    if (h == 0 || colors == null || colors.length == 0) {
      return 0;
    }

    int min = Integer.MAX_VALUE;
    int[][] dp = new int[h][colors.length];

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < colors.length; j++) {
        if (i == 0) {
          dp[i][j] = colors[j];
        } else {
          min = Integer.MAX_VALUE;
          for (int k = 0; k < colors.length; k++) {
            if (k == j)
              continue;
            min = Math.min(min, dp[i - 1][k]);
          }
          dp[i][j] = min + colors[j];
        }
      }
    }

    min = Integer.MAX_VALUE;
    for (int k = 0; k < colors.length; k++) {
      min = Math.min(min, dp[h - 1][k]);
    }
    return min;
  }

  public static void main(String[] args) {
    Random r = new Random();
    int N = 10;
    int[] a1 = new int[N];
    System.out.println();
    for (int i = 0; i < N; i++) {
      a1[i] = r.nextInt(10);
      System.out.print(a1[i] + ", ");
    }
    System.out.println();
    int re = minCost(50, a1);
    System.out.println(re);

  }

}
