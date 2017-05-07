package leetcode09.string;

public class Exam_50 {

  static public boolean isUniq(String s) {
    if (s == null || s.length() < 2) {
      return true;
    }
    boolean[] b = new boolean[256];
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (b[c]) {
        return false;
      }
      b[c] = true;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isUniq("1234"));
    System.out.println(isUniq("123dfda4"));
  }

}
