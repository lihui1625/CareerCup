package zcy08.array;

import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_121 {

  public static void main(String[] args) {
    Random r = new Random();
    int M = 20;
    int[] a1 = new int[M];

    for (int i = 0; i < M; i++) {
      a1[i] = r.nextInt(10) - 5;
    }
    CommonUtils.printArray(a1);
    modify(a1);
    CommonUtils.printArray(a1);

  }

  private static void modify(int[] a1) {
    if (a1 == null || a1.length < 2) {
      return;
    }

    int odd = 1;
    int even = 0;
    while (odd < a1.length && even < a1.length) {
      if ((a1[a1.length - 1] & 1) == 0) {
        swap(a1, even, a1.length - 1);
        even += 2;

      } else {
        swap(a1, odd, a1.length - 1);
        odd += 2;
      }
    }

  }

  private static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

}
