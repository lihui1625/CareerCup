package zcy08.array;

public class Exam_108 {

  public static void spin(int[][] a) {
    if (a == null || a.length == 0 || a[0].length == 0) {
      return;
    }
    int m = a.length;
    int n = a[0].length;

    for (int i = 0; i < (m + 1) / 2; i++) {
      int tmp = a[i][i];
      a[i][i] = a[n - 1 - i][i];
      a[n - 1 - i][i] = a[n - 1 - i][n - 1 - i];
      a[n - 1 - i][n - 1 - i] = a[i][n - 1 - i];
      a[i][n - 1 - i] = tmp;

      for (int j = i + 1; j <= n - 2 - i; j++) {
        tmp = a[i][j];
        a[i][j] = a[n - 1 - j][i];
        a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
        a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
        a[j][n - 1 - i] = tmp;
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[][] a = { { 1, 2, 3, 4, 21 }, { 5, 6, 7, 8, 22 }, { 9, 10, 11, 12, 23 },
        { 13, 14, 15, 16, 24 }, { 25, 26, 27, 28, 29 } };
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        System.out.print(a[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println();

    spin(a);
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        System.out.print(a[i][j] + "\t");
      }
      System.out.println();
    }

  }

}
