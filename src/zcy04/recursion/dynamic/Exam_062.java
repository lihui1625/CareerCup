package zcy04.recursion.dynamic;

import java.util.Random;

public class Exam_062 {

  public static String longestCommonSubString(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return null;
    }
    int len1 = s1.length();
    int len2 = s2.length();
    if (len1 == 0 || len2 == 0) {
      return "";
    }
    int[][] dp = new int[len1][len2];

    int maxLen = 0;
    int endX = 0;
    int endY = 0;
    for (int i = 0; i < len2; i++) {
      dp[0][i] = (s1.charAt(0) == s2.charAt(i) ? 1 : 0);
      if (maxLen == 0 && dp[0][i] == 1) {
        maxLen = 1;
        endY = i;
      }
    }
    for (int i = 0; i < len1; i++) {
      dp[i][0] = (s1.charAt(0) == s2.charAt(i) ? 1 : 0);
      if (maxLen == 0 && dp[i][0] == 1) {
        maxLen = 1;
        endX = i;
      }
    }

    for (int i = 1; i < len1; i++) {
      for (int j = 1; j < len2; j++) {
        if (s1.charAt(i) == s2.charAt(j)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          if (maxLen < dp[i][j]) {
            maxLen = dp[i][j];
            endX = i;
            endY = j;
          }

        } else {
          dp[i][j] = 0;
        }
      }
    }

    System.out.println("length: " + maxLen);
    if (maxLen == 0) {
      return "";
    }
    if (endX > endY) {
      return s1.substring(endX + 1 - maxLen, endX + 1);
    } else {
      return s2.substring(endY + 1 - maxLen, endY + 1);
    }
  }

  public static String longestCommonSubString2(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return null;
    }
    int len1 = s1.length();
    int len2 = s2.length();
    if (len1 == 0 || len2 == 0) {
      return "";
    }
    int[][] dp = new int[len1][len2];

    for (int i = 0; i < len2; i++) {
      dp[0][i] = (s1.charAt(0) == s2.charAt(i) ? 1 : 0);

    }
    for (int i = 0; i < len1; i++) {
      dp[i][0] = (s1.charAt(0) == s2.charAt(i) ? 1 : 0);

    }

    for (int i = 1; i < len1; i++) {
      for (int j = 1; j < len2; j++) {
        if (s1.charAt(i) == s2.charAt(j)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = 0;
        }
      }
    }
    int maxLen = 0;
    int endX = 0;
    for (int i = 0; i < len1; i++) {
      for (int j = 0; j < len2; j++) {
        if (maxLen < dp[i][j]) {
          maxLen = dp[i][j];
          endX = i;
        }
      }
    }

    System.out.println("length: " + maxLen);
    if (maxLen == 0) {
      return "";
    }

    return s1.substring(endX + 1 - maxLen, endX + 1);

  }

  public static String longestCommonSubString3(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return null;
    }
    int len1 = s1.length();
    int len2 = s2.length();
    if (len1 == 0 || len2 == 0) {
      return "";
    }

    int startX = len1 - 1;
    int startY = 0;

    int maxLen = 0;
    int endX = len1 - 1;

    while (startY < len2) {

      int thisLen = 0;
      for (int i = startX, j = startY; i < len1 && j < len2; i++, j++) {
        if (s1.charAt(i) == s2.charAt(j)) {
          thisLen++;
        } else {
          thisLen = 0;
        }
        if (maxLen < thisLen) {
          maxLen = thisLen;
          endX = i;
        }
      }

      if (startX > 0) {
        startX--;
      } else {
        startY++;
      }
    }

    System.out.println("length: " + maxLen);
    if (maxLen == 0) {
      return "";
    }

    return s1.substring(endX + 1 - maxLen, endX + 1);

  }

  public static void main(String[] args) {
    Random r = new Random();
    int M = 150;
    char[] a1 = new char[M];

    for (int i = 0; i < M; i++) {
      a1[i] = (char) (r.nextInt(4) + 'A');
    }

    int N = 150;
    char[] a2 = new char[N];

    for (int i = 0; i < N; i++) {
      a2[i] = (char) (r.nextInt(4) + 'A');
    }
    String s1 = (new String(a1));
    String s2 = (new String(a2));

    System.out.println(s1);
    System.out.println(s2);
    String result = longestCommonSubString(s1, s2);
    System.out.println(result);

    String result2 = longestCommonSubString2(s1, s2);
    System.out.println(result2);

    String result3 = longestCommonSubString3(s1, s2);
    System.out.println(result3);
  }

}
