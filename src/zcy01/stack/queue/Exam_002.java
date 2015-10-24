package zcy01.stack.queue;

import java.util.Stack;

public class Exam_002 {

	public static void main(String[] args) {
		QueueByStack<Integer> stack = new QueueByStack<Integer>();
		stack.add(3);
		stack.add(2);
		stack.add(1);
		stack.add(5);
		stack.add(4); 
		System.out.println("" + stack.poll());
		System.out.println("" + stack.poll());
		System.out.println("" + stack.poll());
		stack.add(15);
		stack.add(14); 
		System.out.println("" + stack.poll());
		System.out.println("" + stack.poll()); 
		System.out.println("" + stack.poll());
		System.out.println("" + stack.poll()); 

	}

}

class QueueByStack<T> {
	private Stack<T> stackIn;
	private Stack<T> stackOut;

	public QueueByStack() {
		stackIn = new Stack<T>();
		stackOut = new Stack<T>();
	}

	public T add(T t) {

		return this.stackIn.push(t);
	}

	public T poll() {
		if (this.stackOut.isEmpty()) {
			while (!this.stackIn.isEmpty()) {
				this.stackOut.push(this.stackIn.pop());
			}
		}
		return this.stackOut.pop();

	}

	public T peek() {
		if (this.stackOut.isEmpty()) {
			while (!this.stackIn.isEmpty()) {
				this.stackOut.push(this.stackIn.pop());
			}
		}
		return this.stackOut.peek();
	}

	public boolean isEmpty() {
		return this.stackIn.isEmpty() && this.stackOut.empty();
	}
}