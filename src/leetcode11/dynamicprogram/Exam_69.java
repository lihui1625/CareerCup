package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_69 {

  public static int minProduct(int[] a, int[] b) {

    int m = a.length;
    int n = b.length;

    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = i; j < i + 1 + (n - m); j++) {
        if (j == i) {
          if (i == 0) {
            dp[i][j] = a[i] * b[j];
          } else {
            dp[i][j] = a[i] * b[j] + dp[i - 1][j - 1];
          }

        } else {
          if (i == 0) {
            dp[i][j] = Math.min(a[i] * b[j], dp[i][j - 1]);
          } else {
            dp[i][j] = Math.min(a[i] * b[j] + dp[i - 1][j - 1], dp[i][j - 1]);
          }
        }

      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    Random r = new Random();
    int N = 2;
    int[] a1 = new int[N];
    System.out.println();
    for (int i = 0; i < N; i++) {
      a1[i] = r.nextInt(10);
      System.out.print(a1[i] + ", ");
    }
    System.out.println();

    N = 4;
    int[] a2 = new int[N];
    System.out.println();
    for (int i = 0; i < N; i++) {
      a2[i] = r.nextInt(10);
      System.out.print(a2[i] + ", ");
    }
    System.out.println();

    int product = minProduct(a1, a2);
    System.out.println(product);
  }

}
