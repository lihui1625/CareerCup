package zcy05.string;

public class Exam_081 {

  public static String replaceSpace(char[] a, int len) {
    int len2 = 0;
    int j = a.length - 1;
    for (int i = len - 1; i >= 0; i--) {
      if (a[i] != ' ') {
        a[j--] = a[i];
        len2++;
      } else {
        a[j--] = '0';
        a[j--] = '2';
        a[j--] = '%';
        len2 += 3;
      }
    }

    return String.valueOf(a, a.length - len2, len2);
  }

  public static String moveStarTohead(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    System.out.println(s);
    char[] array = s.toCharArray();
    int j = array.length - 1;
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] != '*' && i != j) {
        array[j--] = array[i];
      }
    }
    for (int i = j; i >= 0; i--) {
      array[i] = '*';
    }
    return String.valueOf(array);
  }

  public static void main(String[] args) {
    char[] a = new char[100];
    a[0] = 'a';
    a[1] = ' ';
    a[2] = 'b';
    a[3] = ' ';
    a[4] = ' ';
    a[5] = 'c';
    ;
    a[6] = ' ';
    System.out.println(replaceSpace(a, 7));

    System.out.println(moveStarTohead("*12**2134**243**"));

  }

}
