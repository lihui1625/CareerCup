package zcy01.stack.queue;

import java.util.Stack;

public class Exam_001 {

	public static void main(String[] args) {
		StackWithMin<Integer> s = new StackWithMin<>();
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(5);
		s.push(3);
		s.push(4);
		s.push(9);
		System.out.println("" + s.pop() + "," + s.min());
		System.out.println("" + s.pop() + "," + s.min());
		System.out.println("" + s.pop() + "," + s.min());
		System.out.println("" + s.pop() + "," + s.min());
		System.out.println("" + s.pop() + "," + s.min());

	}

}

class StackWithMin<T extends Comparable<T>> {
	private Stack<T> stack1;
	private Stack<T> stack2;

	public StackWithMin() {
		stack1 = new Stack<T>();
		stack2 = new Stack<T>();
	}

	public T pop() {
		if (!this.stack1.isEmpty()) {
			T obj = this.stack1.pop();
			if (obj == this.stack2.peek()) {
				this.stack2.pop();
			}
			return obj;
		} else {
			return null;
		}

	}

	public T min() {
		return this.stack2.peek();

	}

	public T push(T t) {
		if (!this.stack1.isEmpty()) {
			if (t.compareTo(this.stack1.peek()) <= 0) {
				this.stack2.push(t);
			}
		} else {
			this.stack2.push(t);
		}
		return this.stack1.push(t);

	}

	public boolean isEmpty() {
		return this.stack1.empty();
	}

}