package zcy08.array;

import java.util.Arrays;
import java.util.Random;

import leetcode11.dynamicprogram.CommonUtils;

public class Exam_130 {

  public static void main(String[] args) {
    Random r = new Random();
    int M = 4;
    int[][] a = new int[M][M];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < M; j++) {
        a[i][j] = r.nextInt(3) > 0 ? 1 : 0;
      }
      CommonUtils.printArray(a[i]);
    }
    a[0][0] = 1;
    a[M - 1][M - 1] = 1;
    int b = minPath(a);
    System.out.println(b);
  }

  private static int minPath(int[][] a) {
    // TODO Auto-generated method stub
    return 0;
  }

}
