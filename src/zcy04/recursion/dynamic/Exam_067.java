package zcy04.recursion.dynamic;

public class Exam_067 {

  public static int getNumber(String exp, boolean desired) {

    if (exp == null || exp.length() == 0 || isValid(exp)) {
      return 0;
    }

    int len = exp.length();
    int[][] t = new int[len][len];
    int[][] f = new int[len][len];

    for (int i = 0; i < len; i += 2) {
      t[i][i] = (exp.charAt(i) == '1' ? 1 : 0);
      f[i][i] = (exp.charAt(i) == '0' ? 1 : 0);
    }

    for (int i = 2; i < len; i += 2) {

      for (int j = i - 2; j >= 0; j -= 2) {
        for (int k = j; k < i; k += 2) {
          if (exp.charAt(k + 1) == '&') {
            t[j][i] += t[j][k] * t[k + 2][i];
            f[j][i] += (f[j][k] + t[j][k]) * f[k + 2][i]
                + f[j][k] * t[k + 2][i];

          } else if (exp.charAt(k + 1) == '|') {

            t[j][i] += (f[j][k] + t[j][k]) * t[k + 2][i]
                + t[j][k] * f[k + 2][i];
            f[j][i] += f[j][k] * f[k + 2][i];
          } else if (exp.charAt(k + 1) == '^') {
            t[j][i] += f[j][k] * t[k + 2][i] + t[j][k] * f[k + 2][i];

            f[j][i] += f[j][k] * f[k + 2][i] + t[j][k] * t[k + 2][i];
          }

        }
      }
    }

    return desired ? t[len - 1][len - 1] : f[len - 1][len - 1];
  }

  private static boolean isValid(String exp) {
    if (exp.length() % 2 == 0) {
      return false;
    }
    for (int i = 0; i < exp.length(); i += 2) {
      if (exp.charAt(i) != '1' && exp.charAt(i) != '0') {
        return false;
      }
    }
    for (int i = 1; i < exp.length(); i += 2) {
      if (exp.charAt(i) != '|' && exp.charAt(i) != '&'
          && exp.charAt(i) != '^') {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "1^((0|0)|1)";
    boolean desired = false;
    int no = getNumber(s, desired);
    System.out.println(no);
  }

}
