package zcy01.stack.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_007 {

  public static void main(String[] args) {
    Random r = new Random();
    int N = 50;
    int[] a1 = new int[N];

    for (int j = 0; j < N; j++) {
      a1[j] = r.nextInt(6);
    }

    CommonUtils.printArray(a1);
    int window = 5;
    // int[] path1 = maxWindowValue(a1, window);
    // CommonUtils.printArray(path1);

    int[] path12 = maxWindowValue2(a1, window);
    CommonUtils.printArray(path12);

    // int[] a2 = new int[] { 4, 3, 5, 4, 3, 3, 6, 7 };
    // CommonUtils.printArray(a2);
    //
    // int[] path2 = maxWindowValue(a2, window);
    // CommonUtils.printArray(path2);
    //
    // int[] path22 = maxWindowValue2(a2, window);
    // CommonUtils.printArray(path22);
  }

  private static int[] maxWindowValue(int[] a1, int window) {
    if (a1 == null || a1.length == 0) {
      return a1;
    }
    int[] result = new int[a1.length - window + 1];
    for (int i = 0; i < a1.length + 1 - window; i++) {
      int left = i;
      int right = left + window - 1;
      int max = a1[left];
      for (int j = left + 1; j <= right; j++) {
        max = Math.max(max, a1[j]);
      }
      result[left] = max;
    }
    return result;
  }

  private static int[] maxWindowValue2(int[] a1, int window) {
    if (a1 == null || a1.length == 0) {
      return a1;
    }
    Deque<Integer> deque = new LinkedList<>();
    int[] result = new int[a1.length - window + 1];
    for (int right = 0; right < a1.length; right++) {
      int left = right - window + 1;
      while (true) {
        if (deque.isEmpty()) {
          deque.addFirst(right);
          System.out.println("add first:" + "a[" + right + "]=" + a1[right]);
          break;
        }
        if (a1[deque.peekLast()] > a1[right]) {
          deque.addLast(right);
          System.out.println("add last:" + "a[" + right + "]=" + a1[right]);
          break;
        }
        System.out.println("remove last:" + "a[" + deque.peekLast() + "]="
            + a1[deque.peekLast()]);
        deque.pollLast();
      }
      if (deque.peekFirst() < left) {
        System.out.println("remove fisrt:" + "a[" + deque.peekFirst() + "]="
            + a1[deque.peekFirst()]);
        deque.pollFirst();
      }
      if (left >= 0) {
        result[left] = a1[deque.peekFirst()];
      }
      print(a1, deque, left);
    }
    return result;
  }

  private static void print(int[] a1, Deque<Integer> deque, int left) {
    LinkedList<Integer> list = (LinkedList<Integer>) deque;
    System.out.print(left + " --------------- : ");
    int size = list.size();
    for (int i = size - 1; i >= 0; i--) {
      System.out.print("a[" + list.get(i) + "]=" + a1[list.get(i)] + ",");
    }
    System.out.println();

  }

}
