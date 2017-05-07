package zcy04.recursion.dynamic;

public class Exam_060 {

  static public void hano(int num) {
    String from = "FROM";
    String buffer = "BUFFER";
    String to = "TO";
    move(num, from, buffer, to);
  }

  static private void move(int num, String from, String buffer, String to) {
    if (num <= 0) {
      return;
    }
    move(num - 1, from, to, buffer);
    moveStep(num, from, to);
    move(num - 1, buffer, from, to);

  }

  static private void moveStep(int num, String s1, String s2) {
    System.out.println(num + ":" + s1 + " --> " + s2);

  }

  public static void main(String[] args) {
    System.out.println("-------" + 1 + "------");
    hano(1);
    System.out.println("-------" + 2 + "------");
    hano(2);
    System.out.println("-------" + 3 + "------");
    hano(3);
    System.out.println("-------" + 4 + "------");
    hano(4);

  }

}
