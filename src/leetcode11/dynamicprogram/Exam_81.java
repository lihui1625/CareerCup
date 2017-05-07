package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_81 {

  public static void main(String[] args) {
    Random r = new Random();
    int N = 50;

    StringBuilder s1 = new StringBuilder();
    for (int i = 0; i < N; i++) {
      s1.append((char) (r.nextInt(5) + 'a'));

    }
    System.out.println(s1.toString());
    System.out.println(longestPlindromic(s1.toString()));
  }

  public static String longestPlindromic(String s) {

    int len = s.length();
    int start = 0;
    int maxLen = 1;

    boolean[][] dp = new boolean[len][len];

    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }

    for (int i = 0; i < len - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        dp[i][i + 1] = true;
        start = i;
        maxLen = 2;
      }
    }

    for (int i = len - 3; i >= 0; i--) {
      for (int j = i + 2; j < len; j++) {
        if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
          dp[i][i + 1] = true;
          start = i;
          maxLen = j - i + 1;
        }
      }
    }
    System.out.println("start:" + start + "\tlen" + maxLen);
    return s.substring(start, start + maxLen);
  }

}
