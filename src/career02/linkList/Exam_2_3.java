package career02.linkList;

public class Exam_2_3 {

	public static void removeNode(LinkNode node) {
		if (node == null)
			return;
		if (node.next == null)
			throw new RuntimeException("can't remove");

		LinkNode nextNode = node.next;
		node.val = nextNode.val;
		node.next = nextNode.next;
		nextNode.next = null;
		nextNode = null;
	}

	public static void main(String[] args) {
		LinkList linkList = new LinkList();
		linkList.insertOnFirdst(1);
		linkList.insertOnFirdst(4);
		linkList.insertOnFirdst(2);
		linkList.insertOnFirdst(13);
		linkList.insertOnFirdst(3);
		linkList.insertOnFirdst(11);
		linkList.insertOnFirdst(41);
		linkList.insertOnFirdst(15);
		linkList.insertOnFirdst(2);
		linkList.insertOnFirdst(13);
		linkList.insertOnFirdst(3);
		linkList.insertOnFirdst(11);
		linkList.print();
		removeNode(null);
		linkList.print();

	}

}
