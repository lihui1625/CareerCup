package leetcode18.oop;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Exam_140 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

interface Data<T> {
  public boolean isCollection();

  public Collection<Data<T>> getColecton();

  public T getElement();
}

class CpmpleaxIterator<T> implements Iterator<T> {

  private boolean isCollection;
  private List<T> colletion;
  private Iterator<T> iterator;

  public CpmpleaxIterator(Collection<Data<T>> dataCollection) {
    this.colletion = new LinkedList<>();
    this.init(dataCollection);
    this.iterator = colletion.iterator();
  }

  private void init(Collection<Data<T>> dataCollection) {
    for (Data<T> data : dataCollection) {
      this.isCollection = data.isCollection();
      if (this.isCollection) {
        this.init(data.getColecton());
      } else {
        colletion.add(data.getElement());
      }
    }
  }

  @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    return iterator.hasNext();
  }

  @Override
  public T next() {
    // TODO Auto-generated method stub
    return iterator.next();
  }

  @Override
  public void remove() {
    iterator.remove();
  }

}