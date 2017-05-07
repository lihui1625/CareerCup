package career09.recursion.dynamic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exam_9_4 {

  private static Set<Set<Integer>> getAllSet(int[] array) {
    int len = array.length;
    Set<Set<Integer>> allList = new HashSet<>();
    long total = 1 << len;
    for (int i = 0; i < total; i++) {
      Set<Integer> list = new HashSet<>();
      for (int j = 0; j < len; j++) {
        int v = i >> j;
        if ((v & 1) == 1) {
          list.add(array[j]);
        }
      }
      allList.add(list);
    }
    return allList;
  }

  public static void main(String[] args) {
    int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
    Set<Set<Integer>> allList = getAllSet(array);
    for (Set<Integer> list : allList) {
      System.out.println(list);
    }

  }

}
