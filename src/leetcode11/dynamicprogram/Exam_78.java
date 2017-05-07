package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_78 {

  public static int numDistinct(String s, String t) {
    if (s == null || t == null) {
      return 0;
    }
    int lenS = s.length();
    int lenT = t.length();

    if (lenT == 0 || lenS == 0 || lenT > lenS) {
      return 0;
    }

    int[][] dp = new int[lenS + 1][lenT + 1];
    for (int i = 0; i <= lenS; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i <= lenS; i++) {
      for (int j = 1; j <= lenT; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }

      }
    }

    return dp[lenS][lenT];
  }

  public static void main(String[] args) {
    Random r = new Random();
    int N = 2;

    StringBuilder s = new StringBuilder();
    for (int i = 0; i < 50 * N; i++) {
      s.append((char) (r.nextInt(25) + 'a'));

    }
    System.out.println(s.toString());

    StringBuilder t = new StringBuilder();
    for (int i = 0; i < N; i++) {
      t.append((char) (r.nextInt(25) + 'a'));
    }
    System.out.println(t.toString());

    int numDistinct = numDistinct(s.toString(), t.toString());
    System.out.println(numDistinct);
  }

}
