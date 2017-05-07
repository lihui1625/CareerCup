package zcy05.string;

public class Exam_077 {

  public static String replace(String s, String from, String to) {

    if (s == null || from == null || to == null || s.length() == 0
        || from.length() == 0) {
      return s;
    }

    StringBuilder sb = new StringBuilder();

    boolean isRelacedJustNow = false;
    boolean isStart = false;
    int fromIndex = 0;
    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);

      if (cur == from.charAt(fromIndex)) {
        isStart = true;
        fromIndex++;
        if (fromIndex == from.length()) {
          if (!isRelacedJustNow) {
            sb.append(to);
            isRelacedJustNow = true;
          }
          isStart = false;
          fromIndex = 0;
        } else if (i == s.length() - 1) {
          sb.append(from.substring(0, fromIndex));
          break;
        }
      } else {
        if (isStart) {
          sb.append(from.substring(0, fromIndex));
          isStart = false;
          fromIndex = 0;
        }
        sb.append(cur);
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(replace("a111sdaf11ds1", "11", "22"));

  }

}
