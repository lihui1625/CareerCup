package zcy02.linktable;



public class MyLinkList {

	public MyLinkNode head;
	public MyLinkNode tail;

	public MyLinkList() {
		head = null;
		tail = null;
	}

	public boolean insertOnFirst(int val) {
		MyLinkNode node = new MyLinkNode(val);
		if(head!=null){
			head.previous = node;
		}
		node.next = head;
		head = node;
		if (tail == null) {
			tail = node;
		}
		return true;
	}

	public boolean insertOnLast(int val) {
		MyLinkNode node = new MyLinkNode(val);
		if (tail == null) {
			tail = node;
		} else {
			node.previous = tail;
			tail.next = node;
			tail = node;
		}
		if (head == null) {
			head = node;
		}
		return true;
	}

	public boolean remove(Object val) {
		if (head == null)
			return false;
		if (head.val.equals(val)) {
			if (head == tail) {
				tail = null;
			}
			MyLinkNode node = head.next;
			node.previous = null;
			head.next = null;
			head = node;
			return true;
		}
		MyLinkNode previous = head;
		MyLinkNode p = head.next;
		while (p != null) {
			if (p.val == val) {
				if (p == tail) {
					tail = previous;
				}
				MyLinkNode q = p.next;
				previous.next = q.next;
				q.previous = previous;
				p.next = null;
				p = previous;

			} else {
				previous = p;
				p = p.next;
			}
		}

		return false;
	}

	public void print() {
		MyLinkNode p = head;
		System.out.print("[ ");
		while (p != null) {
			System.out.print(p.val + " --> ");
			p = p.next;
		}
		System.out.println(" ] ");
	}

	public static void main(String[] args) {
		MyLinkList linkList = new MyLinkList();
		linkList.insertOnFirst(1);
		linkList.insertOnFirst(4);
		linkList.insertOnFirst(2);
		linkList.insertOnFirst(13);
		linkList.insertOnFirst(3);
		linkList.insertOnFirst(11);
		linkList.insertOnFirst(41);
		linkList.insertOnFirst(15);
		linkList.print();
		linkList.remove(13);
		linkList.print(); 
		 

	}

}
