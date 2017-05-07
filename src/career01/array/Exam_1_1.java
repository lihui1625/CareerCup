package career01.array;

import java.util.Arrays;
import java.util.HashSet;

public class Exam_1_1 {

  public static boolean isDiffrent(String s) {
    if (s == null) {
      return true;

    }
    char[] array = s.trim().toCharArray();
    Arrays.sort(array);
    for (int i = 0, len = array.length; i < len - 1; i++) {
      if (array[i] == array[i + 1]) {
        return false;
      }
    }

    return true;
  }

  public static boolean isDiffrent2(String s) {
    if (s == null) {
      return true;

    }
    char[] array = s.trim().toCharArray();

    HashSet<Character> set = new HashSet<>();

    for (int i = 0, len = array.length; i < len; i++) {
      if (set.contains(array[i])) {
        return false;
      } else {
        set.add(array[i]);
      }
    }

    return true;
  }

  public static boolean isDiffrent3(String s) {
    if (s == null) {
      return true;

    }
    char[] array = s.trim().toCharArray();

    // int[] set = new int[256];
    boolean[] set = new boolean[256];

    for (int i = 0, len = array.length; i < len; i++) {
      // if (set[array[i]]==1) {
      // return false;
      // }
      // else{
      // set[array[i]] = 1;
      // }
      if (set[array[i]]) {
        return false;
      } else {
        set[array[i]] = true;
      }

    }

    return true;
  }

  public static void main(String[] args) {
    String s = "asdfgqwertyuiop~!@#$%^&*()_";
    System.out.println(isDiffrent(s));
    System.out.println(isDiffrent2(s));
    System.out.println(isDiffrent3(s));

    s = "asdgfxcfasddfdad#@";
    System.out.println(isDiffrent(s));
    System.out.println(isDiffrent2(s));
    System.out.println(isDiffrent3(s));
  }

}
