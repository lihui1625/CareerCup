package algorithm.collections;

import java.util.LinkedList;
import java.util.List;

public class ListCloneTest {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    LinkedList<String> list2 = (LinkedList<String>) list.clone();
    list2.set(0, "hhhhhhh");
    System.out.println(list);
    System.out.println(list2);

  }

}
