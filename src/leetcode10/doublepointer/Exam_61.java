package leetcode10.doublepointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Exam_61 {

  public static HashSet<HashSet<Integer>> getSumElem(int[] im, int sum) {
    HashSet<HashSet<Integer>> list = new HashSet<>();
    HashSet<Integer> set = new HashSet<>();
    for (int i : im) {
      set.add(i);
    }
    for (int i = 0; i < im.length - 1; i++) {
      for (int j = i + 1; j < im.length; j++) {
        if (im[i] == im[j]) {
          continue;
        }
        int other = sum - im[i] - im[j];
        if (im[i] == other || im[j] == other || !set.contains(other)) {
          continue;
        }
        HashSet<Integer> l = new HashSet<>();
        l.add(im[i]);
        l.add(im[j]);
        l.add(other);
        list.add(l);
      }
    }
    return list;

  }

  public static void main(String[] args) {
    Random r = new Random();
    int N = 30;
    int[] im = new int[N];
    for (int i = 0; i < N; i++) {
      im[i] = r.nextInt(10);
    }
    System.out.println(Arrays.toString(im));
    System.out.println(getSumElem(im, 15));
  }

}
