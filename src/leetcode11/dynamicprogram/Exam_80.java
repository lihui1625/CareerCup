package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_80 {

  public static void main(String[] args) {
    Random r = new Random();
    int N = 5;

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

    StringBuilder s3 = new StringBuilder();
    for (int i = 0; i < 2 * N; i++) {
      s3.append((char) (r.nextInt(5) + 'a'));

    }
    System.out.println(s3.toString());
    // String s3 = s1.toString() + s2.toString();

    boolean isInterleave = isInterleave(s1.toString(), s2.toString(),
        s3.toString());
    System.out.println(isInterleave);
    System.out.println("----------------------");
    String s4 = s1.toString() + s2.toString();
    System.out.println(s1.toString());
    System.out.println(s2.toString());
    System.out.println(s4);
    isInterleave = isInterleave(s1.toString(), s2.toString(), s4);
    System.out.println(isInterleave);

  }

  private static boolean isInterleave(String s1, String s2, String s3) {
    int len1 = s1.length();
    int len2 = s2.length();
    int len3 = s3.length();
    if (len1 + len2 != len3) {
      return false;
    }

    boolean[][] dp = new boolean[len1 + 1][len2 + 1];
    dp[0][0] = true;
    for (int i = 0; i <= len1; i++) {
      for (int j = 0; j <= len2; j++) {
        if (dp[i][j]
            || (i - 1 >= 0 && dp[i - 1][j]
                && s2.charAt(i - 1) == s3.charAt(i + j - 1))
            || (j - 1 >= 0 && dp[i][j - 1]
                && s1.charAt(j - 1) == s3.charAt(i + j - 1))) {
          dp[i][j] = true;
        } else {
          dp[i][j] = false;
        }
      }
    }

    return dp[len1][len2];
  }

}
