package career03.stack.queue;

public class Exam_3_3 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class SetOfStacks {

  private int MAX_STACK_COUNT = 100;
  private int MAX_STACK_SIZE = 50;

  private MyStack[] myStackArray;
  private int now_stack_index = 0;
  private int[] stack_point;

  public SetOfStacks(int MAX_STACK_COUNT, int MAX_STACK_SIZE) {
    this.MAX_STACK_COUNT = MAX_STACK_COUNT;
    this.MAX_STACK_SIZE = MAX_STACK_SIZE;
    myStackArray = new MyStack[MAX_STACK_COUNT];
    stack_point = new int[MAX_STACK_COUNT];
  }

  public boolean push(Object obj) {
    if (myStackArray[now_stack_index] == null) {
      myStackArray[now_stack_index] = new MyStack();
    }
    if (stack_point[now_stack_index] == MAX_STACK_SIZE - 1) {
      if (now_stack_index == MAX_STACK_COUNT - 1) {
        return false;
      } else {
        myStackArray[++now_stack_index] = new MyStack();
      }
    }
    myStackArray[now_stack_index].push(obj);
    stack_point[now_stack_index]++;
    return true;

  }

  public Object pop() {
    if (stack_point[now_stack_index] == 0) {
      if (now_stack_index == 0) {
        return null;
      } else {
        stack_point[now_stack_index - 1]--;
        return myStackArray[now_stack_index - 1].pop();
      }
    }
    stack_point[now_stack_index]--;
    return myStackArray[now_stack_index].pop();
  }

  public Object popAt(int stack_index) {
    if (stack_index < 0 || stack_index > now_stack_index
        || stack_point[stack_index] == 0) {
      return null;
    }
    stack_point[stack_index]--;
    return myStackArray[stack_index].pop();
  }

}