package leetcode15.permutation.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam_121 {

  public static List<int[]> nQueue(int qNum) {
    int[] colomns = new int[qNum];
    for (int columnNum = 0; columnNum < qNum; columnNum++) {
      colomns[columnNum] = -1;
    }
    List<int[]> result = new ArrayList<>();
    nQueue(qNum, 0, colomns, result);
    return result;
  }

  private static void nQueue(int qNum, int row, int[] colomns,
      List<int[]> result) {
    if (qNum == row) {
      result.add(colomns.clone());
      return;
    }
    for (int col = 0; col < qNum; col++) {
      if (!check(row, col, colomns)) {
        continue;
      }
      colomns[row] = col;
      nQueue(qNum, row + 1, colomns, result);

    }

  }

  private static boolean check(int row, int col, int[] colomns) {
    for (int kRow = 0; kRow < row; kRow++) {
      int kCol = colomns[kRow];
      if (kCol == -1) {
        continue;
      }
      if (kCol == col || (Math.abs(row - col) == Math.abs(kRow - kCol))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    List<int[]> result = nQueue(4);
    for (int[] a : result) {
      System.out.println(Arrays.toString(a));
    }
    System.out.println(result.size());

  }

}
