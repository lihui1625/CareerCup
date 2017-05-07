package algorithm.collections;

public class PrimeTest {

  public static void main(String[] args) {
    int num = 3599;
    int end = (int) Math.sqrt(num) + 1;
    boolean isPrime = true;
    for (int i = 2; i <= end; i++) {
      if (num % i == 0) {
        isPrime = false;
        System.out.println("没是，梅亭！被整除" + i);
        break;
      }
    }
    if (isPrime)
      System.out.println("是的，梅亭！");

  }

}
