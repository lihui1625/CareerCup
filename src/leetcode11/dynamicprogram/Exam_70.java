package leetcode11.dynamicprogram;

import java.util.Random;

public class Exam_70 {

  public static int maxProfit(int[] prices) {
    if (prices == null) {
      return 0;
    }
    int len = prices.length;
    if (len < 2) {
      return 0;
    }

    int[] currentProfit = new int[len];
    int[] futrueProfit = new int[len];

    int lowPrice = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < len; i++) {
      lowPrice = Math.min(lowPrice, prices[i]);
      currentProfit[i] = Math.max(currentProfit[i - 1], prices[i] - lowPrice);
    }

    int highPrice = prices[len - 1];
    for (int i = len - 1; i >= 0; i--) {
      highPrice = Math.max(highPrice, prices[i]);
      if (i < len - 1) {
        futrueProfit[i] = Math.max(futrueProfit[i + 1],
            highPrice - futrueProfit[i]);
      }
      maxProfit = Math.max(maxProfit, currentProfit[i] + futrueProfit[i]);
    }
    return maxProfit;

  }

  public static void main(String[] args) {
    Random r = new Random();
    int N = 10;
    int[] a1 = new int[N];
    System.out.println();
    for (int i = 0; i < N; i++) {
      a1[i] = r.nextInt(10);
      System.out.print(a1[i] + ", ");
    }
    System.out.println();
    System.out.println("Max Profit:" + maxProfit(a1));

  }

}
