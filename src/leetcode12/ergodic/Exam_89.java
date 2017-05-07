package leetcode12.ergodic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Exam_89 {

  public static int transformLen(String s1, String s2, HashSet<String> dict) {

    if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
      return -1;
    }
    if (s1.equals(s2)) {
      return 0;
    }

    Queue<String> curQueue = new LinkedList<>();

    curQueue.add(s1);

    int count = 1;

    while (curQueue.size() > 0) {
      Queue<String> nextQue = new LinkedList<>();
      count++;
      while (curQueue.size() > 0) {
        String word = curQueue.poll();
        List<String> transformList = getTransformList(word, dict, s2);
        for (String tf : transformList) {
          if (tf.equals(s2)) {
            return count;
          }
          nextQue.add(tf);
        }
      }
      curQueue.clear();
      curQueue.addAll(nextQue);
    }
    return -1;
  }

  private static List<String> getTransformList(String word,
      HashSet<String> dict, String s2) {
    List<String> result = new LinkedList<>();
    for (int i = 0; i < word.length(); i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        if (word.charAt(i) != c) {
          String newStr = (i > 0 ? word.substring(0, i) : "") + c
              + (i < word.length() - 1 ? word.substring(i + 1) : "");
          if (newStr.equals(s2)) {

            result.clear();
            result.add(newStr);
            return result;
          }
          if (dict.contains(newStr)) {
            result.add(newStr);
          }
        }

      }
    }

    return result;
  }

  public static void main(String[] args) {

    String s1 = "hit";
    String s2 = "cog";
    HashSet<String> set = new HashSet<>();
    set.add("hot");
    set.add("dot");
    set.add("dog");
    set.add("lot");
    set.add("log");
    System.out.println(transformLen(s1, s2, set));
  }

}
