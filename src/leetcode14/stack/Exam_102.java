package leetcode14.stack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Exam_102 {

  public static void main(String[] args) {
    Random r = new Random();
    int N = 200;
    PriorityQueue<Integer> heap = new PriorityQueue<>(100,
        new Comparator<Integer>() {

          @Override
          public int compare(Integer o1, Integer o2) {
            return o2 - o1;
          }

        });
    for (int i = 0; i < N; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      int num = (int) (r.nextInt(99999) * (i / (i + 1.0)));
      System.out.print("add:" + num);
      heap.add(num);
      System.out.println("\tmax:" + heap.peek());

    }

  }

}
