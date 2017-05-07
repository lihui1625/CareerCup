package career01.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exam_1_3 {

  public static boolean canChange(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.length() != s2.length()) {
      return false;
    }
    char[] array1 = s1.toCharArray();
    char[] array2 = s2.toCharArray();

    Arrays.sort(array1);
    Arrays.sort(array2);

    int len = array1.length;

    for (int i = 0; i < len; i++) {
      if (array1[i] != array2[i]) {
        return false;
      }
    }
    return true;
  }

  public static boolean canChange2(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.length() != s2.length()) {
      return false;
    }

    int len = s1.length();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < len; i++) {
      if (map.containsKey(s1.charAt(i))) {
        int c = map.get(s1.charAt(i));
        map.put(s1.charAt(i), c + 1);
      } else {
        map.put(s1.charAt(i), 1);
      }
    }
    for (int i = 0; i < len; i++) {
      if (map.containsKey(s2.charAt(i))) {
        int c = map.get(s2.charAt(i));
        if (c > 1) {
          map.put(s2.charAt(i), c - 1);
        } else {
          map.remove(s2.charAt(i));
        }
      } else {
        return false;
      }
    }

    return true;
  }

  public static boolean canChange3(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.length() != s2.length()) {
      return false;
    }

    int len = s1.length();
    int[] map = new int[256];
    for (int i = 0; i < len; i++) {
      map[s1.charAt(i)]++;
    }
    for (int i = 0; i < len; i++) {
      map[s2.charAt(i)]--;
      if (map[s2.charAt(i)] < 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String s1 = "zxcv", s2 = "vcxz";
    System.out.println(canChange(s1, s2));
    System.out.println(canChange2(s1, s2));
    System.out.println(canChange3(s1, s2));
    s1 = "zxcv";
    s2 = "zxdv";
    System.out.println(canChange(s1, s2));
    System.out.println(canChange2(s1, s2));
    System.out.println(canChange3(s1, s2));

  }

}
