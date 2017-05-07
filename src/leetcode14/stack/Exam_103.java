package leetcode14.stack;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Exam_103 {

  public static int maxArea(int[] a) {
    int len = a.length;
    int maxArea = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    for (int i = 0; i < len; i++) {
      if (stack.peek() < 0 || a[stack.peek()] <= a[i]) {
        stack.push(i);
      } else {
        Integer pre = stack.pop();
        int thisArea = a[pre] * (i - stack.peek() - 1);
        maxArea = Math.max(maxArea, thisArea);
        i--;
      }
    }
    while (stack.peek() != -1) {
      int pre = stack.pop();
      int thisArea = a[pre] * (len - stack.peek() - 1);
      maxArea = Math.max(maxArea, thisArea);
    }
    return maxArea;

  }

  public static void main(String[] args) {
    Random r = new Random();
    int N = 10;
    int[] a = new int[N];
    for (int i = 0; i < N; i++) {

      a[i] = r.nextInt(9) + 1;

    }
    System.out.println(Arrays.toString(a));
    System.out.println(maxArea(a));
  }

}
