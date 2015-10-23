package career04.tree.graph;

public class Exam_4_5 {

	public static boolean isSousuo(TreeNode root) {

		return isSousuo(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isSousuo(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.val < min || root.val >= max) {
			return false;
		}
		return isSousuo(root.left, min, root.val)
				&& isSousuo(root.right, root.val, max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
