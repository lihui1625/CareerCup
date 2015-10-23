package zcy01.stack.queue;

import java.util.Stack;

public class Exam_003 {

	public static void main(String[] args) {
		MyStackByRec<Integer> stack = new MyStackByRec<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.reverse();
		System.out.println("" + stack.pop());
		System.out.println("" + stack.pop());
		System.out.println("" + stack.pop());
		System.out.println("" + stack.pop());
		System.out.println("" + stack.pop());
	}
}

class MyStackByRec<T> {
	private Stack<T> stack;

	public MyStackByRec() {
		stack = new Stack<T>();
	}

	public T pop() {
		return stack.pop();
	}

	public T peek() {
		return stack.peek();
	}

	public T push(T t) {
		return stack.push(t);
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	private T getFirst() {
		T t = this.stack.pop();
		if (this.stack.isEmpty()) {
			return t;
		} else {
			T last = this.getFirst();
			this.stack.push(t);
			return last;
		}
	}

	public void reverse() {
		if (this.stack.isEmpty()) {
			return;
		}
		T t = this.getFirst();
		this.reverse();
		this.stack.push(t);
	}

}