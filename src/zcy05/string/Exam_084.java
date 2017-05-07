package zcy05.string;

public class Exam_084 {

  public static String getHW(String s) {
    if (s == null || s.isEmpty() || s.length() == 1) {
      return s;
    }

    int[][] dp = new int[s.length()][s.length()];
    for (int j = 1; j < s.length(); j++) {
      dp[j - 1][j] = (s.charAt(j - 1) == s.charAt(j) ? 0 : 1);
      for (int i = j - 2; i >= 0; i--) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1] + 1);
        }

      }
    }
    char[] result = new char[s.length() + dp[0][s.length() - 1]];
    int i = 0;
    int j = s.length() - 1;
    int resLeft = 0;
    int resRight = result.length - 1;

    while (i <= j) {
      if (s.charAt(i) == s.charAt(j)) {
        result[resLeft++] = s.charAt(i++);
        result[resRight--] = s.charAt(j--);
      } else if (dp[i][j - 1] < dp[i + 1][j]) {
        result[resLeft++] = s.charAt(j);
        result[resRight--] = s.charAt(j--);
      } else {
        result[resLeft++] = s.charAt(i);
        result[resRight--] = s.charAt(i++);
      }
    }

    return String.valueOf(result);
  }

  public static void main(String[] args) {
    String s = "adsfds";
    System.out.println(getHW(s));
  }

}
