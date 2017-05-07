package leetcode14.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Exam_107 {

  public static String simplePath(String path) {
    if (path == null || path.isEmpty()) {
      return "";
    }
    String[] paths = path.split("/");
    Deque<String> deque = new LinkedList<>();
    for (int i = 0; i < paths.length; i++) {
      if (paths[i].equals(".") || paths[i].isEmpty()) {
        continue;
      } else if (paths[i].equals("..")) {
        if (!deque.isEmpty())
          deque.pollLast();
      } else {
        if (i == 0 && !path.startsWith("/")) {
          deque.addLast(paths[i]);
        } else {
          deque.addLast("/" + paths[i]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!deque.isEmpty()) {
      sb.append(deque.pollFirst());
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String path = "/d/a/./b//../c/aaa/../d/";
    System.out.println(simplePath(path));
    String path2 = "d/../c/aaa/../d/";
    System.out.println(simplePath(path2));

  }

}
