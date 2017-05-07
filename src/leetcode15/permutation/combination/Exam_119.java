package leetcode15.permutation.combination;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Exam_119<T> {

  @SuppressWarnings("unchecked")
  public LinkedList<LinkedList<T>> subSet(List<T> sourceList) {
    LinkedList<LinkedList<T>> resultList = new LinkedList<>();
    resultList.add(new LinkedList<T>());
    List<Set<Integer>> usedSetList = new LinkedList<>();
    usedSetList.add(new HashSet<Integer>());
    subSet(sourceList, resultList, 0);
    return resultList;
  }

  private void subSet(List<T> sourceList, LinkedList<LinkedList<T>> resultList,
      int level) {
    if (level == sourceList.size()) {
      return;
    }
    List<LinkedList<T>> newResultList = new LinkedList<>();
    for (int k = 0; k < resultList.size(); k++) {
      LinkedList<T> list = resultList.get(k);
      HashSet<T> set = new HashSet<>(list);
      for (int i = 0; i < sourceList.size(); i++) {
        if (set.contains(sourceList.get(i))) {
          continue;
        }
        LinkedList<T> newList = (LinkedList<T>) list.clone();
        newList.add(sourceList.get(i));
        newResultList.add(newList);
      }
    }
    resultList.clear();
    resultList.addAll(newResultList);
    subSet(sourceList, resultList, ++level);
  }

  public static void main(String[] args) {
    List<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    System.out.println((new Exam_119<Integer>()).subSet(list));

  }
}
