package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_83 {

  public static void main(String[] args) {
    Random r = new Random();
    int N = 50;

    StringBuilder s1 = new StringBuilder();
    for (int i = 0; i < N; i++) {
      s1.append((char) (r.nextInt(5) + 'a'));

    }
    System.out.println(s1.toString());

    StringBuilder s2 = new StringBuilder();
    for (int i = 0; i < N; i++) {
      s2.append((char) (r.nextInt(5) + 'a'));

    }
    System.out.println(s2.toString());

    System.out.println(lcs(s1.toString(), s2.toString()));

  }

  private static String lcs(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return "";
    }
    int len1 = s1.length();
    int len2 = s2.length();
    if (len1 == 0 || len2 == 0) {
      return "";
    }

    int maxLen = 0;
    String res = "";
    int[][] dp = new int[len1][len2];

    for (int i = 0; i < len1; i++) {
      for (int j = 0; j < len1; j++) {
        if (s1.charAt(i) == s2.charAt(j)) {
          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          }
          if (maxLen < dp[i][j]) {
            maxLen = dp[i][j];
            res = s1.substring(i + 1 - dp[i][j], i + 1);
          }
        }

      }
    }

    return res;
  }

}
