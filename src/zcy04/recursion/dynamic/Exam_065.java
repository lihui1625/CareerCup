package zcy04.recursion.dynamic;

import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_065 {

  public static void main(String[] args) {
    Random r = new Random();
    int M = 5;
    int N = 10;
    int[][] a1 = new int[M][N];

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        a1[i][j] = r.nextInt(10) - 9;
      }
    }
    a1 = new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 0, 30, -5 } };
    CommonUtils.printArray(a1);
    int blood = gameBlood(a1);
    System.out.println(blood);
    int blood2 = gameBlood(a1);
    System.out.println(blood2);

  }

  private static int gameBlood(int[][] a1) {

    if (a1 == null || a1.length == 0 || a1[0] == null || a1[0].length == 0) {
      return 0;
    }
    int len1 = a1.length;
    int len2 = a1[0].length;
    int[][] dp = new int[len1][len2];

    dp[len1 - 1][len2 - 1] = a1[len1 - 1][len2 - 1] > 0 ? 1
        : (1 - a1[len1 - 1][len2 - 1]);

    for (int i = len1 - 1; i > 0; i--) {
      dp[i - 1][0] = Math.max(dp[i][0] - a1[i - 1][0], 1);
    }
    for (int j = len2 - 1; j > 0; j--) {
      dp[0][j - 1] = Math.max(dp[0][j - 1] - a1[0][j - 1], 1);
    }

    for (int i = len1 - 1; i > 0; i--) {
      for (int j = len2 - 1; j > 0; j--) {
        int v1 = Math.max(dp[i - 1][j] - a1[i][j], 1);
        int v2 = Math.max(dp[i][j - 1] - a1[i][j], 1);
        dp[i - 1][j - 1] = Math.min(v1, v2);

      }
    }

    return dp[0][0];
  }

  private static int gameBlood2(int[][] a1) {

    if (a1 == null || a1.length == 0 || a1[0] == null || a1[0].length == 0) {
      return 0;
    }
    int len1 = a1.length;
    int len2 = a1[0].length;
    int[][] dp = new int[len1][len2];

    dp[len1 - 1][len2 - 1] = a1[len1 - 1][len2 - 1] > 0 ? 1
        : (1 - a1[len1 - 1][len2 - 1]);

    for (int i = len1 - 1; i > 0; i--) {
      dp[i - 1][0] = Math.max(dp[i][0] - a1[i - 1][0], 1);
    }
    for (int j = len2 - 1; j > 0; j--) {
      dp[0][j - 1] = Math.max(dp[0][j - 1] - a1[0][j - 1], 1);
    }

    for (int i = len1 - 1; i > 0; i--) {
      for (int j = len2 - 1; j > 0; j--) {
        int v1 = Math.max(dp[i - 1][j] - a1[i][j], 1);
        int v2 = Math.max(dp[i][j - 1] - a1[i][j], 1);
        dp[i - 1][j - 1] = Math.min(v1, v2);

      }
    }

    return dp[0][0];
  }

}
