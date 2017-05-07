package zcy08.array;

import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_116 {

  public static int getMaxLength(int[] a, int k) {
    if (a == null || a.length == 0) {
      return 0;
    }
    int left = 0;
    int right = 0;
    int len = 0;
    int sum = 0;
    while (right < a.length) {

      if (sum == k) {
        len = Math.max(len, right - left + 1);
        sum -= a[left];
        left++;
      } else if (sum > k) {
        sum -= a[left];
        left++;
      } else {
        right++;
        if (right == a.length) {
          break;
        }
        sum += a[right];
      }

    }

    return len;
  }

  public static void main(String[] args) {
    Random r = new Random();
    int M = 20;
    int[] a1 = new int[M];

    for (int i = 0; i < M; i++) {
      a1[i] = r.nextInt(10);
    }
    CommonUtils.printArray(a1);
    int res = getMaxLength(a1, 10);
    System.out.println(res);

  }

}
