package zcy04.recursion.dynamic;

import java.util.Random;

public class Exam_064 {
  public static boolean isCross(String s1, String s2, String s3) {
    if (s1 == null || s2 == null || s3 == null) {
      return false;
    }
    if (s1.length() == 0) {
      return s2.equals(s3);
    }
    if (s2.length() == 0) {
      return s1.equals(s3);
    }
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
    dp[0][0] = true;
    for (int i = 1; i <= s1.length(); i++) {
      dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
    }
    for (int j = 1; j <= s2.length(); j++) {
      dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
    }
    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        dp[i][j] = ((dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)))
            || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))));
      }
    }

    return dp[s1.length()][s2.length()];
  }

  public static void main(String[] args) {
    Random r = new Random();
    int M = 10;
    char[] a1 = new char[M];

    for (int i = 0; i < M; i++) {
      a1[i] = (char) (r.nextInt(4) + 'A');
    }

    int N = 10;
    char[] a2 = new char[N];

    for (int i = 0; i < N; i++) {
      a2[i] = (char) (r.nextInt(4) + 'A');
    }

    String s1 = (new String(a1));
    String s2 = (new String(a2));

    s1 = "AB";
    s2 = "12";
    String s3 = "A1B2";
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

    boolean result = isCross(s1, s2, s3);
    System.out.println(result);

  }

}
