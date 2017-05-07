package zcy08.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_117 {

  public static void main(String[] args) {
    Random r = new Random();
    int M = 20;
    int[] a1 = new int[M];

    for (int i = 0; i < M; i++) {
      a1[i] = r.nextInt(10) - 5;
    }
    CommonUtils.printArray(a1);
    // int res = getMaxLength(a1, 10);
    // System.out.println(res);
    int res2 = getMaxLength2(a1, 5);
    System.out.println(res2);
  }

  // private static int getMaxLength(int[] a1, int k) {
  //
  // if (a1 == null || a1.length == 0) {
  // return 0;
  // }
  // Map<Integer, Integer> map = new HashMap<>();
  // map.put(0, -1);
  // int len = 0;
  // int sum = 0;
  // for (int i = 0; i < a1.length; i++) {
  // sum += a1[i];
  // if (map.containsKey(sum - k)) {
  // len += Math.max(len, i - map.get(sum - k));
  // }
  // if (!map.containsKey(sum)) {
  // map.put(sum, i);
  // }
  // }
  // return len;
  // }

  private static int getMaxLength2(int[] a1, int k) {

    if (a1 == null || a1.length == 0) {
      return 0;
    }
    Map<Integer, TreeSet<Integer>> map = new HashMap<>();
    for (int i = 0, sum = 0; i < a1.length; i++) {
      sum += a1[i];
      if (!map.containsKey(sum)) {
        map.put(sum, new TreeSet<Integer>());
      }
      map.get(sum).add(i);
    }
    int len = 0;
    for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
      int v1 = entry.getKey();
      TreeSet<Integer> i1Set = entry.getValue();

      int v2 = v1 - k; // 前
      if (map.containsKey(v2)) {
        TreeSet<Integer> i2Set = map.get(v2);
        len = Math.max(len, i1Set.last() - i2Set.first() + 1);

      }

      v2 = v1 + k; // 后
      if (map.containsKey(v2)) {
        TreeSet<Integer> i2Set = map.get(v2);
        len = Math.max(len, i2Set.last() - i1Set.first() + 1);
      }
    }
    return len;
  }

}
