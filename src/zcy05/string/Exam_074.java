package zcy05.string;

public class Exam_074 {

  public static String removeK0(String s, int k) {
    if (s == null || s.length() == 0 || k < 1 || s.length() < k) {
      return s;
    }
    StringBuilder sb = new StringBuilder();
    boolean isStart = false;
    int ct = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c != '0') {
        if (isStart && ct < k) {
          while (ct > 0) {
            sb.append('0');
            ct--;
          }
          isStart = false;
        }
        sb.append(c);
        isStart = false;
      } else {
        if (!isStart) {
          isStart = true;
          ct = 1;
        } else {
          ct++;
          if (ct == k) {
            ct = 0;
            isStart = false;
          }
        }
      }
    }
    return sb.toString();

  }

  public static void main(String[] args) {
    String s = "adsf00asdf000asdf00asdf0f0000d";
    System.out.println(s);
    System.out.println(removeK0(s, 3));

  }

}
