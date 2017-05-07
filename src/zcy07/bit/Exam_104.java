package zcy07.bit;

public class Exam_104 {

  public int count1(int n) {
    int ct = 0;
    while (n != 0) {
      if ((n & 1) > 0) {
        ct++;
      }
      n >>>= 1;
    }

    return ct;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
