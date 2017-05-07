package zcy04.recursion.dynamic;

public class Exam_071 {

  public static int numNQueen(int n) {
    if (n < 1) {
      return 0;
    }
    int[] row2columnSet = new int[n];
    for (int columnNum = 0; columnNum < n; columnNum++) {
      row2columnSet[columnNum] = -1;
    }
    return processNQueen(n, row2columnSet, 0);
  }

  private static int processNQueen(int n, int[] row2columnSet, int rowNum) {
    if (rowNum == n) {
      return 1;
    }
    int result = 0;
    for (int columnNum = 0; columnNum < n; columnNum++) {
      if (isValid(row2columnSet, rowNum, columnNum)) {
        row2columnSet[rowNum] = columnNum;
        result += processNQueen(n, row2columnSet, rowNum + 1);
      }
    }

    return result;

  }

  private static boolean isValid(int[] row2columnSet, int rowNum,
      int columnNum) {
    for (int everyRow = 0; everyRow < rowNum; everyRow++) {
      int everyColumn = row2columnSet[everyRow];
      if (everyColumn == -1) {
        continue;
      }
      if (everyColumn == columnNum
          || Math.abs(rowNum - everyRow) == Math.abs(columnNum - everyColumn)) {

        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(numNQueen(1));
    System.out.println(numNQueen(4));
    System.out.println(numNQueen(8));

  }

}
