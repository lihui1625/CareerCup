package leetcode17.bit;

public class Exam_133 {

  // ob 0000 0000 0000 0000 0000 0000 0000 0001 = 1
  // ob 0000 0000 0000 0000 0000 0000 0000 0100 = 4
  // ob 0000 0000 0000 0000 0000 0000 0001 0000 = 16
  // ob 0000 0000 0000 0000 0000 0000 0100 0000 = 64
  // ob 0000 0000 0000 0000 0000 0001 0000 0000 = 256
  // ob 0000 0000 0000 0000 0000 0100 0000 0000
  // ob 0000 0000 0000 0000 0001 0000 0000 0000

  public static boolean isPowerOf4(int n) {
    if (n <= 0) {
      return false;
    }
    if ((n & (n - 1)) != 0) {
      return false;
    }
    return ((0b10101010101010101010101010101010) & n) == 0;
  }

  public static void main(String[] args) {
    int[] array = { 1, 2, 4, 8, 16, 20, 32, 60, 64, 68, 128, 256, 512, 1024 };
    for (int x : array) {
      System.out
          .println(x + ":" + Integer.toBinaryString(x) + ":" + isPowerOf4(x));
    }

  }

}
