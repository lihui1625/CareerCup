package career01.array;

public class Exam_1_8 {

  static public boolean isSubstring(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    return s1.contains(s2);
  }

  static public boolean isSpanned(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.length() != s2.length()) {
      return false;
    }
    if (s1.length() == 0) {
      return true;
    }
    if (s1.length() == 1) {
      return s1.equals(s2);
    }

    int len = s1.length();

    for (int i = 0; i < len; i++) {
      if (s1.charAt(i) == s2.charAt(0)) {
        String newStr = s1.substring(i) + s1.substring(0, i);
        if (newStr.equals(s2)) {
          return true;
        }
      }
    }

    return false;
  }

  static public boolean isSpanned2(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.length() != s2.length()) {
      return false;
    }
    if (s1.length() == 0) {
      return true;
    }
    if (s1.length() == 1) {
      return s1.equals(s2);
    }

    int len = s1.length();

    for (int i = 0; i < len; i++) {
      int j = 0;
      if (s1.charAt(i) == s2.charAt(0)) {
        int s1Cut = i;
        while (true) {
          if (i == len - 1) {
            return s1.substring(0, s1Cut).equals(s2.substring(j + 1));
          }
          i++;
          j++;
          if (s1.charAt(i) != s2.charAt(j)) {
            break;
          }
        }
      }
    }

    return false;
  }

  static public boolean isSpanned3(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.length() != s2.length()) {
      return false;
    }
    if (s1.length() == 0) {
      return true;
    }
    if (s1.length() == 1) {
      return s1.equals(s2);
    }

    String s1s1 = s1 + s1;

    return isSubstring(s1s1, s2);
  }

  public static void main(String[] args) {
    String s1 = "zxcvbnm", s2 = "vbnmzxc";
    System.out.println(isSpanned(s1, s2));
    System.out.println(isSpanned2(s1, s2));
    System.out.println(isSpanned3(s1, s2));
    s1 = "zxcvbnm";
    s2 = "vbnmtxc";
    System.out.println(isSpanned(s1, s2));
    System.out.println(isSpanned2(s1, s2));
    System.out.println(isSpanned3(s1, s2));
  }

}
