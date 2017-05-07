package leetcode13.hash;

import java.util.HashMap;

public class Exam_97 {

  public static void main(String[] args) {
    MyStruct<String> s = new MyStruct<>(100);
    s.inert("a");
    s.inert("b");
    s.inert("c");
    s.inert("d");
    s.del("b");
    System.out.println(s.get(0));
    System.out.println(s.get(1));
    System.out.println(s.get(2));
  }

}

class MyStruct<T> {

  private HashMap<T, Integer> map;
  private T[] array;
  private int len;
  private int maxSize;

  MyStruct(int maxSize) {
    this.map = new HashMap<>(maxSize);
    this.array = (T[]) new Object[maxSize];
    this.maxSize = maxSize;
    this.len = 0;
  }

  public void inert(T t) {
    if (this.len >= this.maxSize) {
      throw new RuntimeException("no space");
    }
    array[len] = t;
    map.put(t, len);
    len++;
  }

  public void del(T t) {
    if (map.containsKey(t)) {
      int pt = map.remove(t);
      array[pt] = array[len - 1];
      map.put(array[pt], len - 1);
      len--;
    }
  }

  public boolean contains(T t) {
    return this.map.containsKey(t);
  }

  public T get(int i) {
    if (i < 0 || i > len - 1) {
      throw new RuntimeException("no space");
    }
    return this.array[i];
  }

  public int size() {
    return len;
  }

}
