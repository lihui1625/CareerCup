package leetcode14.stack;

import java.util.Random;
import java.util.Stack;

public class Exam_110 {

	public static void main(String[] args) {
		MinStack<Integer> minStack = new MinStack<>();
		
		Random r = new Random();
		int N = 20; 
		for (int i = 0; i < N; i++) { 
			minStack.push(r.nextInt(10));
 		}
		for (int i = 0; i < N; i++) { 
			System.out.println(minStack.min()+":" +minStack );
			minStack.pop();
 		} 
	}

}

class MinStack<T extends Comparable<T>> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public MinStack() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public T pop() {
		stack2.pop(); 
		return stack1.pop();
	}

	public void push(T t) {
		
		if (stack2.isEmpty() || stack2.peek().compareTo(t) >= 0) {
			stack2.push(t);
		}else{
			stack2.push(stack2.peek());
		}
		stack1.push(t);
	}

	public T peek() {
		return stack1.peek();
	}

	public T min() {
		return stack2.peek();
	}
	
	public boolean isEmpty(){
		return stack1.isEmpty();
	}

	@Override
	public String toString() {
		return "MinStack [stack1=" + stack1 + ", stack2=" + stack2 + "]";
	}
	
	
	
}