package zcy08.array;

public class Exam_109 {

  public static void main(String[] args) {
    int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        System.out.print(a[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println();

    printArray(a);

  }

  private static void printArray(int[][] a) {
    if (a == null || a.length == 0 || a[0].length == 0) {
      return;
    }
    int m = a.length;
    int n = a[0].length;

    boolean lastIsUp = false;
    int lastUpX = -1;
    int lastUpY = -1;
    for (int i = 0; i <= (m + n - 1); i++) {
      int upX = Math.max(0, i - n);
      int upY = Math.min(i, n - 1);
      if (lastUpX == upX && lastUpY == upY) {
        continue;
      }

      int downX = Math.min(i, m - 1);
      int downY = Math.max(0, i - m);

      if (lastIsUp) {
        for (int j = upX, k = upY; j <= downX && k >= downY; j++, k--) {
          System.out.print(a[j][k] + "\t");
        }
      } else {
        for (int j = downX, k = downY; j >= upX && k <= upY; j--, k++) {
          System.out.print(a[j][k] + "\t");
        }
      }
      lastUpX = upX;
      lastUpY = upY;

      lastIsUp = !lastIsUp;
    }
    System.out.println();

  }

}
