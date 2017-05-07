package career03.stack.queue;

public class Exam_3_5 {

  public static void main(String[] args) {
    MyQueueByStack myStack = new MyQueueByStack();
    myStack.push(1);
    myStack.push(2);
    myStack.push(5);
    myStack.push(6);
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    myStack.push(100);
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    myStack.push(3);
    myStack.push(4);
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());

  }

}

class MyQueueByStack {
  private MyStack stackIn;
  private MyStack stackOut;

  public MyQueueByStack() {
    stackIn = new MyStack();
    stackOut = new MyStack();
  }

  public int size() {
    return this.stackIn.size() + this.stackOut.size();
  }

  public void push(Object obj) {
    this.stackIn.push(obj);
  }

  public Object pop() {
    if (this.stackOut.size() == 0) {
      while (this.stackIn.size() > 0) {
        this.stackOut.push(this.stackIn.pop());
      }
    }
    return this.stackOut.pop();
  }

  public Object peek() {
    if (this.stackOut.size() == 0) {
      while (this.stackIn.size() > 0) {
        this.stackOut.push(this.stackIn.pop());
      }
    }
    return this.stackOut.peek();
  }

}