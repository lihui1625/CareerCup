package career16.thread;

import java.util.concurrent.Semaphore;

public class Exam_16_5 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class Foo {

  public Semaphore sem1, sem2, sem3;

  public Foo() {
    sem1 = new Semaphore(1);
    sem2 = new Semaphore(1);
    sem3 = new Semaphore(1);

    try {
      sem1.acquire();
      sem2.acquire();
      sem3.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void first() {
    try {

    } finally {
      sem1.release();
    }
  }

  public void second() {

    try {
      sem1.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      sem1.release();
      sem2.release();
    }

  }

  public void third() {
    try {
      sem2.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      sem2.release();
    }
  }

}