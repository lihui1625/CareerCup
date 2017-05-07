package career09.recursion.dynamic;

public class Exam_9_3 {

  public static int getIndexNoRepeated(int[] array) {
    return getIndexNoRepeated(array, 0, array.length - 1);
  }

  private static int getIndexNoRepeated(int[] array, int start, int to) {
    if (start > to) {
      return -1;
    }
    int mid = (start + to) / 2;
    if (array[mid] == mid) {
      return mid;
    } else if (array[mid] > mid) {
      return getIndexNoRepeated(array, start, mid - 1);
    } else {
      return getIndexNoRepeated(array, mid + 1, to);
    }
  }

  public static int getIndexRepeated(int[] array) {
    return getIndexRepeated(array, 0, array.length - 1);
  }

  private static int getIndexRepeated(int[] array, int start, int to) {
    if (start > to) {
      return -1;
    }
    int mid = (start + to) / 2;
    if (array[mid] == mid) {
      return mid;
    }

    int left = Math.min(mid - 1, array[mid]);
    int leftResult = getIndexRepeated(array, start, left);
    if (leftResult > -1) {
      return leftResult;
    }

    int right = Math.max(mid + 1, array[mid]);
    int rightResult = getIndexRepeated(array, right, to);

    return rightResult;

  }

  public static void main(String[] args) {
    int[] a1 = new int[] { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
    System.out.println(getIndexNoRepeated(a1));

    int[] a2 = new int[] { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
    System.out.println(getIndexRepeated(a2));

  }

}
