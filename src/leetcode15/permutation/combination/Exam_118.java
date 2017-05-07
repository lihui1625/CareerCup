package leetcode15.permutation.combination;

import java.util.LinkedList;
import java.util.List;

public class Exam_118<T> {

  @SuppressWarnings("unchecked")
  public LinkedList<LinkedList<T>> subSet(List<T> sourceList) {
    LinkedList<LinkedList<T>> resultList = new LinkedList<>();
    resultList.add(new LinkedList<T>());
    for (int i = 0; i < sourceList.size(); i++) {
      List<LinkedList<T>> tmpTesultList = new LinkedList<>();
      for (LinkedList<T> list : resultList) {
        LinkedList<T> newList = (LinkedList<T>) list.clone();
        newList.add(sourceList.get(i));
        tmpTesultList.add(newList);
      }
      resultList.addAll(tmpTesultList);
    }
    return resultList;
  }

  @SuppressWarnings("unchecked")
  public LinkedList<LinkedList<T>> subSet2(List<T> sourceList) {
    LinkedList<LinkedList<T>> resultList = new LinkedList<>();
    for (int i = 0; i <= Math.pow(2, sourceList.size()); i++) {
      int n = i;
      LinkedList<T> newList = new LinkedList<>();
      int index = sourceList.size() - 1;
      while (n > 0) {
        if ((n & 1) == 1) {
          newList.add(sourceList.get(index));
        }
        index--;
        n = n >> 1;
      }
      resultList.add(newList);
    }

    return resultList;
  }

  public static void main(String[] args) {
    List<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    System.out.println((new Exam_118<Integer>()).subSet(list));

  }

}
