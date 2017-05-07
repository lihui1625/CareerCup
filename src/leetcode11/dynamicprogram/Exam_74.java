package leetcode11.dynamicprogram;

public class Exam_74 {

  public static long getFibonacci(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }

    long result_last_1 = 1;
    long result = 2;
    for (int i = 3; i <= n; i++) {
      long result_last_2 = result_last_1;
      result_last_1 = result;
      result = result_last_1 + result_last_2;
    }
    return result;

  }

  public static void main(String[] args) {
    System.out.println(getFibonacci(1));
    System.out.println(getFibonacci(2));
    System.out.println(getFibonacci(3));
    System.out.println(getFibonacci(4));
    System.out.println(getFibonacci(5));
    System.out.println(getFibonacci(6));
    System.out.println(getFibonacci(7));
    System.out.println(getFibonacci(8));
    System.out.println(getFibonacci(9));
    System.out.println(getFibonacci(10));
  }

}
