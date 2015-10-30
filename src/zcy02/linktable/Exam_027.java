package zcy02.linktable;

public class Exam_027 {

	public static void removeNode(MyLinkNode node) {
		if (node.next == null) {
			return;
		}
		if (node.next == null) {
			throw new java.lang.RuntimeException(
					"the last node can't be deleted");
		}
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
