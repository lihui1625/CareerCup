package zcy03.tree;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public TreeNode setVal(int val) {
		this.val = val;
		return this;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode setLeft(TreeNode left) {
		this.left = left;
		return this;
	}

	public TreeNode getRight() {
		return right;
	}

	public TreeNode setRight(TreeNode right) {
		this.right = right;
		return this;
	}

	@Override
	public String toString() {
		return " (" + val + ")";
	}
	
	

}