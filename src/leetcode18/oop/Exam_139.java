package leetcode18.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Exam_139 {

  public static void main(String[] args) {

    // LinkedList<String> t2 = new LinkedList<>();
    // t2.add("1");
    // t2.add("2");
    // t2.add("3");
    // t2.add("4");
    // t2.add("5");
    // t2.add("6");
    // t2.add("7");
    // t2.add("8");
    // t2.add("9");
    // t2.add("10");
    // t2.add("11");
    //
    // for(int i=0;i<t2.size() ;i++){
    // t2.remove(i);
    // }
    // System.out.println(t2);
    // for(String s:t2){
    // t2.remove(s);
    // }
    // System.out.println(t2);

  }

}

class Peekable<T> {
  private Iterator<T> iterator;
  private T top;

  public Peekable(Iterator<T> iterator) {
    this.iterator = iterator;
    if (this.iterator.hasNext()) {
      this.top = this.iterator.next();
    }
  }

  public boolean hasNext() {
    return this.top != null;
  }

  public T next() {
    if (this.top == null) {
      throw new RuntimeException("no element");
    }
    T result = this.top;
    if (this.iterator.hasNext()) {
      this.top = this.iterator.next();
    }
    return result;
  }

  public T peek() {
    return top;
  }

}