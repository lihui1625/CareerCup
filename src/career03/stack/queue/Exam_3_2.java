package career03.stack.queue;

public class Exam_3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class StackWithMin extends BaseStack {
	private BaseStack minStack;

	public StackWithMin() {
		minStack = new BaseStack();
	}

	public void push(Integer obj) {
		super.push(obj);
		if(minStack.peek()==null || obj<=minStack.peek())
		{
			minStack.push(obj);
		}		
	}

	public Integer pop() {
		int v = super.pop();
		if (minStack.peek()!=null && v == minStack.peek()) {
			minStack.pop();
		}
		return v;
	}

	public Integer min() {
		return minStack.peek();
	}

}

class BaseStack {
	private MyLinkNode head;

	public BaseStack() {
		head = null;
	}

	public void push(Integer obj) {
		MyLinkNode node = new MyLinkNode(obj);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public Integer pop() {
		if (head == null) {
			return null;
		}
		MyLinkNode node = head;
		head = node.next;
		node.next = null;
		return (Integer) node.val;
	}

	public Integer peek() {
		if (head == null) {
			return null;
		}
		return (Integer) head.val;
	}

	public void print() {
		head.print();
	}
}