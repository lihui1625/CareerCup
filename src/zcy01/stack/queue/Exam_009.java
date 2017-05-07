package zcy01.stack.queue;

import java.util.Stack;

public class Exam_009 {

  public static int maxRecSize(int[][] a1) {
    if (a1 == null || a1.length == 0 || a1[0] == null || a1[0].length == 0) {
      return 0;
    }
    int maxArea = 0;

    int m = a1.length;
    int n = a1[0].length;

    int[] height = new int[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        height[j] = (a1[i][j] == 0 ? 0 : height[j] + 1);
      }
      maxArea = Math.max(maxArea, maxRecSizeFromButton(height));
    }

    return maxArea;
  }

  private static int maxRecSizeFromButton(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int maxArea = 0;

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty()) {
        if (height[i] > height[stack.peek()]) {
          break;
        }
        int j = stack.pop();
        int k = stack.isEmpty() ? -1 : stack.peek();
        int curArea = (i - k - 1) * height[j];
        maxArea = Math.max(maxArea, curArea);
      }
      stack.push(i);

    }
    while (!stack.isEmpty()) {
      int j = stack.pop();
      int k = stack.isEmpty() ? -1 : stack.peek();
      int curArea = (height.length - k - 1) * height[j];
      maxArea = Math.max(maxArea, curArea);
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int[][] a1 = new int[][] { { 1, 0, 1, 1 }, { 1, 1, 1, 1 },
        { 1, 1, 1, 0 }, };
    System.out.println(maxRecSize(a1));

  }

}
