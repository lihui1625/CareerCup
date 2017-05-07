package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_82 {

  public static void main(String[] args) {
    Random r = new Random();
    int N = 50;

    StringBuilder s1 = new StringBuilder();
    for (int i = 0; i < N; i++) {
      s1.append((char) (r.nextInt(5) + 'a'));

    }
    System.out.println(s1.toString());
    System.out.println(minHuiwenNum(s1.toString()));

  }

  private static int minHuiwenNum(String s) {

    int len = s.length();
    int dp[] = new int[len + 1];
    boolean isPa[][] = new boolean[len][len];

    for (int i = 0; i <= len; i++) {
      dp[i] = len - i - 1;
    }

    for (int i = len - 1; i >= 0; i--) {
      for (int j = i; j < len; j++) {

        if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPa[i + 1][j - 1])) {
          isPa[i][j] = true;
          dp[i] = Math.min(dp[i], dp[j + 1] + 1);

        }
      }
    }

    return dp[0];
  }

}
