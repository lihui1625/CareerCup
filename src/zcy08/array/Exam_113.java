package zcy08.array;

public class Exam_113 {

  public static void main(String[] args) {
    int[][] a = { { 0, 1, 2, 5 }, { 2, 3, 4, 7 }, { 4, 4, 4, 8 },
        { 5, 7, 7, 9 } };

    int[] p = findK(a, 1);
    System.out.println(p[0] + "," + p[1]);

  }

  private static int[] findK(int[][] a, int k) {
    int[] p = { -1, -1 };

    int i = a.length - 1;
    int j = 0;
    while (i >= 0 && j <= a[0].length - 1) {
      if (a[i][j] == k) {
        return new int[] { i, j };
      } else if (a[i][j] > k) {
        i--;
      } else {
        j++;
      }

    }

    return p;
  }

}
