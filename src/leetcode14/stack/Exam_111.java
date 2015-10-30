package leetcode14.stack;

import java.util.Stack;

import zcy03.tree.TreeNode;

public class Exam_111 {

	public static void midOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		midOrder(root.left);
		System.out.print(root.val + "\t");
		midOrder(root.right);
	}

	public static void midOrder2(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode node = root;
		while(node!=null){
			stack.push(node);
			node = node.left;
		}
		while (!stack.isEmpty()) {
			node = stack.pop(); 
			System.out.print(node.val + "\t"); 
			node = node.right;
			while(node!=null){
				stack.push(node);
				node = node.left;
			}
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);

		t1.setLeft(t2).setRight(t3);
		t2.setLeft(t4).setRight(t5);
		t3.setLeft(t6).setRight(t7);

		midOrder(t1);
		System.out.println();
		midOrder2(t1);
		System.out.println();

	}

}
