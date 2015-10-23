package zcy01.stack.queue;

import java.util.Stack;

public class Exam_005 {

	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> anotherStack = new Stack<Integer>();
		while (!stack.isEmpty()) {
			Integer cur = stack.pop();
			if (anotherStack.isEmpty() || anotherStack.peek() >= cur) {
				anotherStack.push(cur);
			} else if (anotherStack.peek() < cur) {
				while (!anotherStack.isEmpty() && anotherStack.peek() < cur) {
					stack.push(anotherStack.pop());
				}
				anotherStack.push(cur);
			}
		}
		while(!anotherStack.isEmpty()){
			stack.push(anotherStack.pop());
		} 
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(5);
		stack.push(4);
		sortStack(stack);
		System.out.println("" + stack.pop());
		System.out.println("" + stack.pop());
		System.out.println("" + stack.pop());
		System.out.println("" + stack.pop());
		System.out.println("" + stack.pop()); 
	}

}
